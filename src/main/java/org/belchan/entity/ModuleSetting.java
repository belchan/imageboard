package org.belchan.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


@Data
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

}