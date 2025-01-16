package uke3;

public class NettStudent extends Student {

	
	private String hjemsted;

	public NettStudent(int studentNummer, String fornavn, String etternavn, String studieby, String hjemsted) {
		super(studentNummer, fornavn, etternavn, studieby);
		this.hjemsted = hjemsted;
	}

	public String getHjemsted() {
		return hjemsted;
	}

	public void setHjemsted(String hjemsted) {
		this.hjemsted = hjemsted;
	}

	@Override
	public String toString() {
		return "NettStudent [hjemsted=" + hjemsted + "]";
	}
	
	
	

}
