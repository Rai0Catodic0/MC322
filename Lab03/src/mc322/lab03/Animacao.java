package mc322.lab03;

public class Animacao{
	AquarioLombriga lombriga;
	int passo;
	String animacao;
	
	public Animacao(String animacao) {
		this.animacao = animacao;
		char[] instrucoes = new char[6];
		animacao.getChars(0, 6, instrucoes, 0);
		int tamanhoAquario = Character.getNumericValue(instrucoes[1]);
		int tamanhoLombriga = Character.getNumericValue(instrucoes[3]);
		int posicao = Character.getNumericValue(instrucoes[5]);
		posicao += tamanhoLombriga-1;
		lombriga= new AquarioLombriga(tamanhoAquario, tamanhoLombriga, posicao);
		passo = 0;
	}
	
	public String apresenta() {
		return this.lombriga.apresenta();
	}
	
	public void passo() {
		if(passo+6<= animacao.length()) {
			char acao = this.animacao.charAt((passo+6));
			switch(acao){
				case 'C':
					this.lombriga.crescer();
					break;
				case 'M':
					this.lombriga.mover();
					break;
				case 'V':
					this.lombriga.virar();
					break;
			}
			this.passo+=1;
		}
	}
}