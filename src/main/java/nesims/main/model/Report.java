package nesims.main.model;

public class Report {
	 
	private long crisisID;
	private String nameOfSender;
    private String positionInPMO;
    private String proposalFeedback;
    private String proposalApproval;

 
    public Report(){
        crisisID=0;
    }
    
    public Report(long crisisID, String nameOfSender, String positionInPMO, String proposalFeedback,
			String proposalApproval) {
		this.crisisID = crisisID;
		this.nameOfSender = nameOfSender;
		this.positionInPMO = positionInPMO;
		this.proposalFeedback = proposalFeedback;
		this.proposalApproval = proposalApproval;
	}

     
	public long getCrisisID() {
		return crisisID;
	}




	public void setCrisisID(long crisisID) {
		this.crisisID = crisisID;
	}




	public String getNameOfSender() {
		return nameOfSender;
	}




	public void setNameOfSender(String nameOfSender) {
		this.nameOfSender = nameOfSender;
	}




	public String getPositionInPMO() {
		return positionInPMO;
	}




	public void setPositionInPMO(String positionInPMO) {
		this.positionInPMO = positionInPMO;
	}




	public String getProposalFeedback() {
		return proposalFeedback;
	}




	public void setProposalFeedback(String proposalFeedback) {
		this.proposalFeedback = proposalFeedback;
	}




	public String getProposalApproval() {
		return proposalApproval;
	}




	public void setProposalApproval(String proposalApproval) {
		this.proposalApproval = proposalApproval;
	}

   
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (crisisID ^ (crisisID >>> 32));
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Report other = (Report) obj;
        if (crisisID != other.crisisID)
            return false;
        return true;
    }
 
    @Override
	public String toString() {
		return "Report [crisisID=" + crisisID + ", nameOfSender=" + nameOfSender + ", positionInPMO=" + positionInPMO
				+ ", proposalFeedback=" + proposalFeedback + ", proposalApproval=" + proposalApproval + "]";
	}
 
 
}