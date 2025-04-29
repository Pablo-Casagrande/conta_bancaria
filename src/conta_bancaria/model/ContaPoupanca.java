package conta_bancaria.model;



public class ContaPoupanca extends Conta{

	private int diaAniversario;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.diaAniversario = aniversario;
	}

	public int getAniversario() {
		return diaAniversario;
	}

	public void setAniversario(int aniversario) {
		this.diaAniversario = aniversario;
	}
	
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversário da conta: " + this.diaAniversario);
	}
    
}