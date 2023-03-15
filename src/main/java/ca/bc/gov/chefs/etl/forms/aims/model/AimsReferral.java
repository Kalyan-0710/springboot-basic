package ca.bc.gov.chefs.etl.forms.aims.model;

import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.core.model.IModel;
import ca.bc.gov.chefs.etl.util.Counter;

public class AimsReferral implements IModel {

	@JsonIgnore
	private String confirmationId;
	@JsonProperty("serviceProviderCode1")
	private String serviceProviderCode;
	@JsonProperty("referralTarget")
	private String referralTarget;

	@JsonProperty("DataGridReferral_date_1")
	private String referralDate;
	
	public String getAimsReferralNumber() {
		return confirmationId.concat("-"+String.valueOf(Counter.getNext(getFormType())));
	}

	public String getServiceProviderCode() {
		return serviceProviderCode;
	}

	public void setConfirmationId(String confirmationId) {
		this.confirmationId = confirmationId;
	}

	public void setServiceProviderCode(String serviceProviderCode) {
		this.serviceProviderCode = serviceProviderCode;
	}

	public String getReferralTarget() {
		return referralTarget;
	}

	public void setReferralTarget(String referralTarget) {
		this.referralTarget = referralTarget;
	}

	@Override
	public String getFileName() {
		return "AIMS_REFERRAL";
	}

	@Override
	public String getFormType() {
		return Constants.AIMS_REFERRAL;
	}

	@Override
	public List<String> getCsvElements() {
		List<String> elements = new ArrayList<>();
		elements.add(this.confirmationId);
		elements.add(this.getAimsReferralNumber());
		elements.add(this.referralDate);
		elements.add(this.serviceProviderCode);
		elements.add(this.referralTarget);
		return elements;
	}

	@Override
	public List<IModel> getObjects() {
		return new ArrayList<>();
	}

}
