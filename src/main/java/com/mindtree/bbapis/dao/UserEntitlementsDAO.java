package com.mindtree.bbapis.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "ENTITLEMENTS")
public class UserEntitlementsDAO {

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isIs_public() {
		return is_public;
	}

	public void setIs_public(boolean is_public) {
		this.is_public = is_public;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public boolean isHide_metadata_if_alias_used() {
		return hide_metadata_if_alias_used;
	}

	public void setHide_metadata_if_alias_used(boolean hide_metadata_if_alias_used) {
		this.hide_metadata_if_alias_used = hide_metadata_if_alias_used;
	}

	public boolean isCan_add_comment() {
		return can_add_comment;
	}

	public void setCan_add_comment(boolean can_add_comment) {
		this.can_add_comment = can_add_comment;
	}

	public boolean isCan_see_bank_account_balance() {
		return can_see_bank_account_balance;
	}

	public void setCan_see_bank_account_balance(boolean can_see_bank_account_balance) {
		this.can_see_bank_account_balance = can_see_bank_account_balance;
	}

	public boolean isCan_see_bank_account_bank_name() {
		return can_see_bank_account_bank_name;
	}

	public void setCan_see_bank_account_bank_name(boolean can_see_bank_account_bank_name) {
		this.can_see_bank_account_bank_name = can_see_bank_account_bank_name;
	}

	public boolean isCan_see_bank_account_currency() {
		return can_see_bank_account_currency;
	}

	public void setCan_see_bank_account_currency(boolean can_see_bank_account_currency) {
		this.can_see_bank_account_currency = can_see_bank_account_currency;
	}

	public boolean isCan_see_bank_account_number() {
		return can_see_bank_account_number;
	}

	public void setCan_see_bank_account_number(boolean can_see_bank_account_number) {
		this.can_see_bank_account_number = can_see_bank_account_number;
	}

	public boolean isCan_see_bank_account_swift_bic() {
		return can_see_bank_account_swift_bic;
	}

	public void setCan_see_bank_account_swift_bic(boolean can_see_bank_account_swift_bic) {
		this.can_see_bank_account_swift_bic = can_see_bank_account_swift_bic;
	}

	public boolean isCan_see_bank_account_type() {
		return can_see_bank_account_type;
	}

	public void setCan_see_bank_account_type(boolean can_see_bank_account_type) {
		this.can_see_bank_account_type = can_see_bank_account_type;
	}

	public boolean isCan_see_bank_account_owners() {
		return can_see_bank_account_owners;
	}

	public void setCan_see_bank_account_owners(boolean can_see_bank_account_owners) {
		this.can_see_bank_account_owners = can_see_bank_account_owners;
	}

	@Id
	@Column(name = "ID", unique = true, length = 10)
	@NotNull
	private String id = "owner";

	@Column(name = "SHORTNAME", length = 10)
	@NotNull
	private String shortName = "Owner";

	@Column(name = "DESCRIPTION")
	@NotNull
	private String description = "Owner view";

	@Column(name = "ISPUBLIC")
	@NotNull
	private boolean is_public = true;

	@Column(name = "ALIAS")
	private String alias = null;

	@Column(name = "HIDEMETADATA", columnDefinition = "boolean")
	@NotNull
	private boolean hide_metadata_if_alias_used = false;

	@Column(name = "ADDCOMMENT")
	@NotNull
	private boolean can_add_comment = true;

	@Column(name = "SEEACCOUNTBALANCE")
	@NotNull
	private boolean can_see_bank_account_balance = true;

	@Column(name = "SEEBANKNAME")
	@NotNull
	private boolean can_see_bank_account_bank_name = true;

	@Column(name = "SEEACCOUNTCURRENCY")
	@NotNull
	private boolean can_see_bank_account_currency = true;

	@Column(name = "SEEACCOUNTNUMBER")
	@NotNull
	private boolean can_see_bank_account_number = true;

	@Column(name = "SEEACCOUNTSWIFTBIC")
	@NotNull
	private boolean can_see_bank_account_swift_bic = true;

	@Column(name = "SEEACCOUNTTYPE")
	@NotNull
	private boolean can_see_bank_account_type = true;

	@Column(name = "SEEBANKACCOUNTOWNERS")
	@NotNull
	private boolean can_see_bank_account_owners = true;
	/*
	 * "can_add_public_alias": true, "can_add_tag": true, "can_add_url": true,
	 * "can_add_where_tag": true, "can_delete_comment": true,
	 * "can_delete_corporate_location": true, "can_delete_image": true,
	 * "can_delete_physical_location": true, "can_delete_tag": true,
	 * "can_delete_where_tag": true, "can_edit_owner_comment": false,
	 * "can_see_bank_account_balance": true, "can_see_bank_account_bank_name":
	 * true, "can_see_bank_account_currency": true, "can_see_bank_account_iban":
	 * true, "can_see_bank_account_label": true,
	 * "can_see_bank_account_national_identifier": true,
	 * "can_see_bank_account_number": true, "can_see_bank_account_owners": true,
	 * "can_see_bank_account_swift_bic": true, "can_see_bank_account_type":
	 * true, "can_see_comments": true, "can_see_corporate_location": true,
	 * "can_see_image_url": true, "can_see_images": true, "can_see_more_info":
	 * true, "can_see_open_corporates_url": true,
	 * "can_see_other_account_bank_name": true, "can_see_other_account_iban":
	 * true, "can_see_other_account_kind": true,
	 * "can_see_other_account_metadata": true,
	 * "can_see_other_account_national_identifier": true,
	 * "can_see_other_account_number": true, "can_see_other_account_swift_bic":
	 * true, "can_see_owner_comment": false, "can_see_physical_location": true,
	 * "can_see_private_alias": true, "can_see_public_alias": true,
	 * "can_see_tags": true, "can_see_transaction_amount": true,
	 * "can_see_transaction_balance": true, "can_see_transaction_currency":
	 * true, "can_see_transaction_description": true,
	 * "can_see_transaction_finish_date": true, "can_see_transaction_metadata":
	 * true, "can_see_transaction_other_bank_account": true,
	 * "can_see_transaction_start_date": true,
	 * "can_see_transaction_this_bank_account": true,
	 * "can_see_transaction_type": true, "can_see_url": true,
	 * "can_see_where_tag": true
	 */
}
