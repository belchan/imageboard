package org.belchan.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the module_settings database table.
 * 
 */
@Entity
@Table(name="module_settings")
@NamedQuery(name="ModuleSetting.findAll", query="SELECT m FROM ModuleSetting m")
public class ModuleSetting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String key;

	private String module;

	private String type;

	@Lob
	private String value;

	public ModuleSetting() {
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}