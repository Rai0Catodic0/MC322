package mc322.lab03;

public class AquarioLombriga{
	int tamanhoAquario;
	int tamanhoLombriga;
	int posicao;
	char lado;
	
	public AquarioLombriga(int tamanhoAquario,int tamanhoLombriga,int posicao){
		this.tamanhoAquario = tamanhoAquario;
		this.tamanhoLombriga = tamanhoLombriga;
		if(this.tamanhoAquario < this.tamanhoLombriga) {
			this.tamanhoAquario += this.tamanhoLombriga;
		}
		if(this.tamanhoLombriga > this.posicao) {
			this.posicao = this.tamanhoLombriga;
		}
		this.posicao = posicao-1;
		this.lado = 'd';
	}
	
	public void virar(){
		if(this.lado=='d') {
			this.posicao = this.posicao-(this.tamanhoLombriga-1);
			this.lado = 'e';
		}
		else {
			this.posicao = this.posicao+(this.tamanhoLombriga-1);
			this.lado = 'd';
		}
		
	}
	
	public void mover(){
		if(this.lado == 'd') {
			if(this.posicao+1<= this.tamanhoAquario) {
				this.posicao+=1;
			}
			else {
				this.virar();
			}
		}
		else {
			if(this.posicao-1>=0) {
				this.posicao-=1;
			}
			else {
				this.virar();
			}
		}
	}
	
	public void crescer() {
		if(this.lado == 'd') {
			if(this.posicao-(this.tamanhoLombriga)>=0) {
				this.tamanhoLombriga +=1;
			}
		}
		else {
			if((this.tamanhoAquario-this.posicao)-this.tamanhoLombriga>0) {
				this.tamanhoLombriga += 1;
			}
		}
		
	}
	
	public String apresenta() {
		char repre[] = new char[this.tamanhoAquario];
		for(int i = 0 ; i<this.tamanhoAquario;i++) {
			repre[i] = '#';
		}
		repre[this.posicao] = '0';
		int tamanho = this.tamanhoLombriga;
		if(this.lado == 'd') {
			for(int i = 1;i < tamanho;i++) {
				repre[(this.posicao-i)] = '@';
			}
		}
		else {
			for(int i = 1;i < tamanho;i++) {
				repre[(this.posicao+i)] = '@';
			}	
		}
		return new String(repre);
	}
	
}