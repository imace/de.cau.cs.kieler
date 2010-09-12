package de.cau.cs.kieler.kex.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Example {

	/**
	 * unique field.
	 */
	private final String title;

	private final List<ExampleResource> resources;

	private final List<String> categories;

	private final SourceType sourceType;

	private final Date generationDate;

	private String description;

	private String contact;

	private String author;

	private String namespaceId;

	private String rootDir;

	private String previewPicPath;

	public Example(final String title, SourceType importType) {
		this.title = title;
		this.sourceType = importType;
		this.resources = new ArrayList<ExampleResource>();
		this.categories = new ArrayList<String>();
		this.generationDate = Calendar.getInstance().getTime();
	}

	@Override
	public String toString() {
		return new StringBuffer().append("Example [title= ").append(getTitle())
				.append(",source type= ").append(
						SourceType.map(this.sourceType)).append(getContact())
				.append(", author= ").append(this.author).append(
						", generated at= ").append(
						this.generationDate.toString()).append(
						", description= ").append(getDescription()).append("]")
				.toString();
	}

	public boolean contains(String category) {
		for (String element : getCategories()) {
			if (category.equals(element))
				return true;
		}
		return false;
	}

	public String getTitle() {
		return this.title;
	}

	public Date getGenerationDate() {
		return this.generationDate;
	}

	public SourceType getSourceType() {
		return this.sourceType;
	}

	public void addCategories(List<String> categories) {
		this.categories.addAll(categories);
	}

	public List<String> getCategories() {
		return categories;
	}

	public void addResources(List<ExampleResource> exampleResources) {
		this.resources.addAll(exampleResources);
	}

	public List<ExampleResource> getResources() {
		return resources;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setNamespaceId(String namespaceId) {
		this.namespaceId = namespaceId;
	}

	public String getNamespaceId() {
		return this.namespaceId;
	}

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	public String getRootDir() {
		return this.rootDir;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setPreviewPicPath(String previewPicPath) {
		this.previewPicPath = previewPicPath;
	}

	public String getPreviewPicPath() {
		return previewPicPath;
	}

}
