package de.cau.cs.kieler.ksbase.ui;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.commands.Category;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.contexts.Context;
import org.eclipse.core.commands.contexts.ContextManager;
import org.eclipse.core.internal.expressions.CountExpression;
import org.eclipse.core.internal.expressions.InstanceofExpression;
import org.eclipse.core.internal.expressions.IterateExpression;
import org.eclipse.core.internal.expressions.WithExpression;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.bindings.Binding;
import org.eclipse.jface.bindings.keys.KeyBinding;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.keys.IBindingService;
import org.eclipse.ui.menus.AbstractContributionFactory;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.services.IServiceLocator;
import org.osgi.framework.BundleContext;

import de.cau.cs.kieler.ksbase.core.EditorTransformationSettings;
import de.cau.cs.kieler.ksbase.core.Transformation;
import de.cau.cs.kieler.ksbase.core.TransformationManager;
import de.cau.cs.kieler.ksbase.ui.handler.TransformationCommandHandler;

/**
 * The activator class controls the plug-in life cycle
 */
@SuppressWarnings("restriction")
public class KSBasEUIPlugin extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "de.cau.cs.kieler.ksbase.ui";

    // The shared instance
    private static KSBasEUIPlugin plugin;

    /**
     * The constructor
     */
    public KSBasEUIPlugin() {
        createMenu();

    }

    public void createMenu() {
        // Foreach editor create menus:
        IMenuService menuService = (IMenuService) PlatformUI.getWorkbench()
                .getService(IMenuService.class);
        final ICommandService cmdService = (ICommandService) PlatformUI
                .getWorkbench().getService(ICommandService.class);
        final IBindingService bindService = (IBindingService)PlatformUI.getWorkbench().getService(IBindingService.class);
        final Category kielerCategory = cmdService
                .getCategory("de.cau.cs.kieler.commands.category");
        final Context context = new ContextManager()
                .getContext("de.cau.cs.kieler.ksbase.context");
        context.define("de.cau.cs.kieler.ksbase.context", "KSBasE Comtext","org.eclipse.gmf.runtime.diagram.ui.diagramContext");
        
        final ArrayList<Binding> bindings = new ArrayList<Binding>();
        for (Binding b : bindService.getBindings()) {
            bindings.add(b);
        }
        
        //
        // !! Hier weiter mit den anderen Menüs und vor allem den visibleWhen
        // Expressions !!
        
        for (final EditorTransformationSettings settings : TransformationManager.instance
                .getEditors()) {

            if (settings.isShownInMenu()
                    && settings.getMenuLocation().length() > 0) {
                // Create menu contributions
                AbstractContributionFactory menuContribution = new AbstractContributionFactory(
                        settings.getMenuLocation(), "de.cau.cs.kieler") {

                    @Override
                    public void createContributionItems(
                            IServiceLocator serviceLocator,
                            IContributionRoot additions) {

                        MenuManager dynamicMenu = new MenuManager(settings
                                .getMenuName(), "de.cau.cs.kieler.ksbase.menu."
                                + settings.getMenuName());
                        for (final Transformation t : settings
                                .getTransformations()) {
                            String cmdID = "de.cau.cs.kieler.ksbase.commands."
                                    + settings.getMenuName() + "."
                                    + t.getName().replace(' ', '_');
                            Command transformationCommand = cmdService
                                    .getCommand(cmdID);
                            if (!transformationCommand.isDefined()) {
                                transformationCommand.define(t.getName(), "",
                                        kielerCategory);
                            }
                            try {
                                transformationCommand
                                        .setHandler(new TransformationCommandHandler(
                                                settings, t));

                                String shortcut = t.getKeyboardShortcut();
                                if (shortcut.length() > 0) {
                                    // shortcut = "CTRL\u002Bx";
                                    KeyStroke ks = KeyStroke
                                            .getInstance(shortcut);
                                    KeySequence k = KeySequence.getInstance(ks);
                                    ParameterizedCommand pCommand = new ParameterizedCommand(
                                            transformationCommand, null);
                                    KeyBinding kb = new KeyBinding(
                                            k,
                                            pCommand,
                                            "org.eclipse.ui.defaultAcceleratorConfiguration",
                                            "de.cau.cs.kieler.ksbase.context",
                                            null, null, null, KeyBinding.USER);
                                    
                                    bindings.add(kb);
                                    
                                }
                                CommandContributionItemParameter p = new CommandContributionItemParameter(
                                        PlatformUI.getWorkbench(), null, cmdID,
                                        CommandContributionItem.STYLE_PUSH);
                                
                                CommandContributionItem cmd = new CommandContributionItem(
                                        p);

                                // create the following structure
                                // iterate and
                                // with selection
                                // iterate or
                                // instance-of class
                                // with selection
                                // count #

                                IterateExpression baseIterate = new IterateExpression(
                                        "and", "false");
                                // Create visibility with instance-of
                                // expressions
                                if (t.getPartConfig().length > 0) {
                                    WithExpression withSelection = new WithExpression(
                                            "selection");
                                    IterateExpression iterate = new IterateExpression(
                                            "or", "false");

                                    for (String part : t.getPartConfig()) {
                                        InstanceofExpression instance = new InstanceofExpression(
                                                part);
                                        iterate.add(instance);
                                    }
                                    withSelection.add(iterate);
                                    baseIterate.add(withSelection);
                                }

                                // Create visibility with count expression
                                WithExpression withSelection = new WithExpression(
                                        "selection");
                                CountExpression ce = new CountExpression(String
                                        .valueOf(t.getNumSelections()));
                                withSelection.add(ce);
                                baseIterate.add(withSelection);

                                additions.registerVisibilityForChild(cmd,
                                        baseIterate);
                                dynamicMenu.add(cmd);
                            } catch (CoreException e) {

                            } catch (ParseException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }

                        WithExpression we = new WithExpression("activeEditor");

                        InstanceofExpression exp = new InstanceofExpression(
                                settings.getEditor());
                        we.add(exp);

                        additions.addContributionItem(dynamicMenu, we);
                    }
                };
                menuService.addContributionFactory(menuContribution);
            }
            if (settings.isShownIToolbar()
                    && settings.getToolbarLocation().length() > 0) {
                // Create menu contributions
                AbstractContributionFactory toolbarContribution = new AbstractContributionFactory(
                        settings.getToolbarLocation(), null) {

                    @Override
                    public void createContributionItems(
                            IServiceLocator serviceLocator,
                            IContributionRoot additions) {

                        ToolBarManager dynamicToolbar = new ToolBarManager();

                        // + settings.getMenuName());
                        for (final Transformation t : settings
                                .getTransformations()) {
                            String cmdID = "de.cau.cs.kieler.ksbase.commands."
                                    + settings.getMenuName() + "."
                                    + t.getName().replace(' ', '_');
                            Command transformationCommand = cmdService
                                    .getCommand(cmdID);
                            if (!transformationCommand.isDefined()) {
                                transformationCommand.define(t.getName(), "",
                                        kielerCategory);
                            }
                            transformationCommand
                                    .setHandler(new TransformationCommandHandler(
                                            settings, t));
                            CommandContributionItemParameter p = new CommandContributionItemParameter(
                                    PlatformUI.getWorkbench(), null, cmdID,
                                    CommandContributionItem.STYLE_PUSH);
                            CommandContributionItem cmd = new CommandContributionItem(
                                    p);
                            if (t.getPartConfig().length > 0) {
                                try {

                                    IterateExpression iterate = new IterateExpression(
                                            "or", "false");

                                    for (String part : t.getPartConfig()) {
                                        InstanceofExpression instance = new InstanceofExpression(
                                                part);
                                        iterate.add(instance);
                                    }
                                    /*
                                     * additions.registerVisibilityForChild(cmd,
                                     * iterate);
                                     */
                                    dynamicToolbar.add(cmd);
                                } catch (CoreException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                };
                menuService.addContributionFactory(toolbarContribution);
            }
        }
        try {
            Binding[] bs = new Binding[bindings.size()];
            System.arraycopy(bindings.toArray(), 0, bs, 0, bindings.size());
            bindService.savePreferences(bindService.getScheme("org.eclipse.ui.defaultAcceleratorConfiguration"), bs);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static KSBasEUIPlugin getDefault() {
        return plugin;
    }

}
