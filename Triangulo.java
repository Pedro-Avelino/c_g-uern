package Computação_grafica;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import javax.swing.JFrame;

/*A JANELA É CRIADA PELO JFRAME */
public class Triangulo extends JFrame {

	int alt, larg;
	Graphics g;

	/*
	 * AQUI TEMOS A CLASSE TRIANGULO, ELA TEM O CONSTRUTOR PADRÃO DELA QUE RECEBE A
	 * ALTURA E A LARGURA QUE É
	 * REFERENTE A JANELA
	 */
	public Triangulo(int alt, int larg) {
		setSize(larg, alt);/* DEFINE O TAMANHO DA TELA */
		setLocationRelativeTo(null);/* CENTRALIZA A TELA COM BASE NO TAMANHO DEFINIDO */
		setDefaultCloseOperation(EXIT_ON_CLOSE);/* FECHA O PROGRAMA AO CLICAR EM SAIR NO JFRAME */
		setVisible(true);/* PERMITIR A VISUALIZAÇÃO */
	}

	/* AQUI TEMOS OS GETTERS E SETTERS SÓ PARA ALTERAR OS PARAMETROS */
	public int getAlt() {
		return alt;
	}

	public void setAlt(int alt) {
		this.alt = alt;
	}

	public int getLarg() {
		return larg;
	}

	public void setLarg(int larg) {
		this.larg = larg;
	}

	public void limpar_tela(Triangulo t) {

		/* PEGA O TAMANHO DA TELA DEFINIDO ANTERIORMENTE */
		Graphics g = getGraphics();
		/* APAGA TODAS AS INTERAÇÕES FEITAS NA TELA */
		g.clearRect(0, 0, t.getAlt(), t.getLarg());

	}

	/*
	 * AQUI TEMOS A PRIMEIRA FUNÇÃO QUE É PARA DESENHAR O TRIANGULO, NELA NOS
	 * RECEBEMOS
	 * OS PARAMETROS INICIAIS DO NOSSO PLANO CARTESIANO QUE É O X0, XF, Y0, YF
	 * E UM TRIANGULO T QUE É O OBJETO QUE VAI DEFINIR A ALTURA E A LARGURA DA NOSSA
	 * TELA
	 */
	public void equacao_diferecial(int x0, int xf, int y0, int yf, Triangulo t) {

		/* AQUI PEGAMOS A RESOLUÇÃO DEFINIDA PELO CONSTRUTOR */
		Graphics g = getGraphics();
		int auxx0, auxxf, auxy0, auxyf, alt, larg;

		auxx0 = x0;
		auxxf = xf;
		auxy0 = y0;
		auxyf = yf;
		/*
		 * AQUI DEFINIMOS A CENTRALIZAÇÃO DO NOSSO PONTO DE ORIGEM PORQUE PADRÃO ELE VEM
		 * NO CANTO SUPERIOR
		 * UTILIZAMOS A ALTURA E A LARGURA PARA DEFINIR O CENTRO DA TELA
		 */
		alt = t.getAlt();
		larg = t.getLarg();

		/* DEFINIR A COR DO DESENHO */
		g.setColor(Color.BLACK);
		/*
		 * DESENHA A LINHA, JÁ CENTRALIZANDO O DESENHO NA TELA COM O CALCULO FEITO
		 * ABAIXO
		 */
		g.drawLine(Math.round(auxx0 + alt / 2), Math.round(larg / 2 - auxy0), Math.round(auxxf + alt / 2),
				Math.round(larg / 2 - auxyf));
		;
		/*
		 * RESUMINDO AQUI NA PRIMEIRA EQUAÇÃO PASSAMOS OS PARAMETROS, AS VARIAVEIS
		 * RECEBEM ESSES PARAMETROS
		 * QUE DEFINIMOS, E O VALORES DE X0,Y0 E XF,YF
		 */
	}

	/*
	 * AQUI NO DE ESCALA VAI SER BASICAMENTE A MESMA COISA DO DE CIMA, SÓ QUE AQUI
	 * USAMOS O CE QUE É O COEFICIENTE ESCALAR E SUBSTITUIMOS A FORMULA ONDE PEGAMOS
	 * OS VALORES E MULTIPLICAMOS POR ESSE COEFICIENTE
	 */
	public void Escala(int x0, int xf, int y0, int yf, Triangulo t, int ce) {

		/* AQUI PEGAMOS A RESOLUÇÃO DEFINIDA PELO CONSTRUTOR */
		Graphics g = getGraphics();
		int auxx0, auxxf, auxy0, auxyf, alt, larg, auxce;

		auxx0 = x0 * ce;
		auxxf = xf * ce;
		auxy0 = y0 * ce;
		auxyf = yf * ce;
		/*
		 * AQUI DEFINIMOS A CENTRALIZAÇÃO DO NOSSO PONTO DE ORIGEM PORQUE PADRÃO ELE VEM
		 * NO CANTO SUPERIOR
		 * UTILIZAMOS A ALTURA E A LARGURA PARA DEFINIR O CENTRO DA TELA
		 */
		alt = t.getAlt();
		larg = t.getLarg();

		/* DEFINIR A COR DO DESENHO */
		g.setColor(Color.BLACK);
		/*
		 * DESENHA A LINHA, JÁ CENTRALIZANDO O DESENHO NA TELA COM O CALCULO FEITO
		 * ABAIXO ONDE ELE RECEBE OS MESMOS VALORES DA EQUAÇÃO DIFERENCIAL
		 */
		g.drawLine(Math.round(auxx0 + alt / 2), Math.round(larg / 2 - auxy0), Math.round(auxxf + alt / 2),
				Math.round(larg / 2 - auxyf));
		;
	}

	/*
	 * A ROTAÇÃO SE DIFERE PORQUE RECEBE UM ANGULO E ESSE ANGULO É SUBSTITUIDO PELA
	 * FORMA MATEMATICA QUE VAI SER O X MULTIPLICANDO O SEN E O COS DO ANGULO MENOS
	 * E MAIS O Y
	 * VEZES O SEN E O COS DO ANGULO
	 */
	public void Rotacao(int x0, int xf, int y0, int yf, Triangulo t, double angulo) {
		/* AQUI PEGAMOS A RESOLUÇÃO DEFINIDA PELO CONSTRUTOR */
		Graphics g = getGraphics();
		int auxx0, auxxf, auxy0, auxyf, alt, larg;

		auxx0 = (int) (x0 * Math.cos(angulo) - y0 * Math.sin(angulo));
		auxy0 = (int) (x0 * Math.sin(angulo) + y0 * Math.cos(angulo));
		auxxf = (int) (xf * Math.cos(angulo) - yf * Math.sin(angulo));
		auxyf = (int) (xf * Math.sin(angulo) + yf * Math.cos(angulo));
		alt = t.getAlt();
		larg = t.getLarg();

		/* DEFINIR A COR DO DESENHO */
		g.setColor(Color.BLACK);
		/*
		 * DESENHA A LINHA, JÁ CENTRALIZANDO O DESENHO NA TELA COM O CALCULO FEITO
		 * ABAIXO ONDE ELE RECEBE OS MESMOS VALORES DA EQUAÇÃO DIFERENCIAL
		 */
		g.drawLine(Math.round(auxx0 + alt / 2), Math.round(larg / 2 - auxy0), Math.round(auxxf + alt / 2),
				Math.round(larg / 2 - auxyf));
		;
	}

	/*
	 * BASICAMENTE AQUI NA TRANSLAÇÃO VAMOS RECEBER DE DIFERENTE UM TX E UM TY QUE É
	 * O
	 * COEFICIENTE DE TRANSLAÇÃO, QUE VÃO SER OS VALORES SOMADOS NAS VARIAVEIS
	 * ABAIXO
	 */
	public void Translatacao(int x0, int xf, int y0, int yf, Triangulo t, int tx, int ty) {
		/* AQUI PEGAMOS A RESOLUÇÃO DEFINIDA PELO CONSTRUTOR */
		Graphics g = getGraphics();
		int auxx0, auxxf, auxy0, auxyf, alt, larg, auxce;

		auxx0 = x0 + tx;
		auxxf = xf + tx;
		auxy0 = y0 + ty;
		auxyf = yf + ty;
		alt = t.getAlt();
		larg = t.getLarg();

		/* DEFINIR A COR DO DESENHO */
		g.setColor(Color.BLACK);
		/*
		 * DESENHA A LINHA, JÁ CENTRALIZANDO O DESENHO NA TELA COM O CALCULO FEITO
		 * ABAIXO ONDE ELE RECEBE OS MESMOS VALORES DA EQUAÇÃO DIFERENCIAL
		 */
		g.drawLine(Math.round(auxx0 + alt / 2), Math.round(larg / 2 - auxy0), Math.round(auxxf + alt / 2),
				Math.round(larg / 2 - auxyf));
		;
	}

	/* O ESPELHAMENTO APENAS SUBSTITUIMOS O VALOR DE Y0 E YF PARA NEGATIVO */
	public void espelhamento(int x0, int xf, int y0, int yf, Triangulo t) {
		/* AQUI PEGAMOS A RESOLUÇÃO DEFINIDA PELO CONSTRUTOR */
		Graphics g = getGraphics();
		int auxx0, auxxf, auxy0, auxyf, alt, larg;

		alt = t.getAlt();
		larg = t.getLarg();
		auxx0 = x0;
		auxxf = xf;
		auxy0 = -y0;
		auxyf = -yf;

		/* DEFINIR A COR DO DESENHO */
		g.setColor(Color.BLACK);
		/*
		 * DESENHA A LINHA, JÁ CENTRALIZANDO O DESENHO NA TELA COM O CALCULO FEITO
		 * ABAIXO ONDE ELE RECEBE OS MESMOS VALORES DA EQUAÇÃO DIFERENCIAL
		 */
		g.drawLine(Math.round(auxx0 + alt / 2), Math.round(larg / 2 - auxy0), Math.round(auxxf + alt / 2),
				Math.round(larg / 2 - auxyf));
		;
	}

	/*
	 * A ESCALA FIXA FUNCIONA DA MESMA FORMA QUE A ESCALA SÓ QUE TEMOS UM PONTO FIXO
	 * NO CASO NAS COORDENADAS QUE VAI SER 55 E 65
	 */
	public void Escala_fixa(int x0, int xf, int y0, int yf, Triangulo t, int ce) {

		/* AQUI PEGAMOS A RESOLUÇÃO DEFINIDA PELO CONSTRUTOR */
		Graphics g = getGraphics();
		int auxx0, auxxf, auxy0, auxyf, alt, larg, auxce;

		auxx0 = x0 * ce + 55 * (1 - ce);
		auxxf = xf * ce + 55 * (1 - ce);
		auxy0 = y0 * ce + 65 * (1 - ce);
		auxyf = yf * ce + 65 * (1 - ce);
		alt = t.getAlt();
		larg = t.getLarg();

		/* DEFINIR A COR DO DESENHO */
		g.setColor(Color.BLACK);
		/*
		 * DESENHA A LINHA, JÁ CENTRALIZANDO O DESENHO NA TELA COM O CALCULO FEITO
		 * ABAIXO ONDE ELE RECEBE OS MESMOS VALORES DA EQUAÇÃO DIFERENCIAL
		 */
		g.drawLine(Math.round(auxx0 + alt / 2 + 55), Math.round(larg / 2 - auxy0 + 65),
				Math.round(auxxf + alt / 2 + 55), Math.round(larg / 2 - auxyf + 65));
		;
	}

	/*
	 * A ROTAÇÃO FIXA FUNCIONA DA MESMA MANEIRA DA ROTAÇÃO SÓ QUE USAMOS COORDENADAS
	 * FIXAS QUE SÃO 55 E 65
	 */
	public void Rotacao_fixa(int x0, int xf, int y0, int yf, Triangulo t, double angulo) {
		/* AQUI PEGAMOS A RESOLUÇÃO DEFINIDA PELO CONSTRUTOR */
		Graphics g = getGraphics();
		int auxx0, auxxf, auxy0, auxyf, alt, larg;

		auxx0 = (int) (x0 * Math.cos(angulo) - y0 * Math.sin(angulo) + 55 * (1 - Math.cos(angulo))
				+ 65 * Math.sin(angulo));
		auxy0 = (int) (x0 * Math.sin(angulo) + y0 * Math.cos(angulo) + 65 * (1 - Math.cos(angulo))
				+ 55 * Math.sin(angulo));
		auxxf = (int) (xf * Math.cos(angulo) - yf * Math.sin(angulo) + 55 * (1 - Math.cos(angulo))
				+ 65 * Math.sin(angulo));
		auxyf = (int) (xf * Math.sin(angulo) + yf * Math.cos(angulo) + 65 * (1 - Math.cos(angulo))
				+ 55 * Math.sin(angulo));
		alt = t.getAlt();
		larg = t.getLarg();

		/* DEFINIR A COR DO DESENHO */
		g.setColor(Color.BLACK);
		/*
		 * DESENHA A LINHA, JÁ CENTRALIZANDO O DESENHO NA TELA COM O CALCULO FEITO
		 * ABAIXO ONDE ELE RECEBE OS MESMOS VALORES DA EQUAÇÃO DIFERENCIAL
		 */
		g.drawLine(Math.round(auxx0 + alt / 2), Math.round(larg / 2 - auxy0), Math.round(auxxf + alt / 2),
				Math.round(larg / 2 - auxyf));
		;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcao;
		System.out.println("INFORME A LARGURA QUE VOCÊ DESEJA USAR");
		int larg = input.nextInt();
		System.out.println("INFORME A ALTURA QUE VOCÊ DESEJA USAR");
		int alt = input.nextInt();

		/* INICIALIZA UM NOVO OBJETO DESENHAR */
		Triangulo t = new Triangulo(alt, larg);
		t.setAlt(alt);
		t.setLarg(larg);

		/* AQUI TEMOS AQUELE MENU PADRÃO */
		while (true) {

			System.out.printf("[0] Desenha triangulo \n" +
					"[1] Escala \n" + "[2] Rotação \n" + "[3] Translatação \n" +
					"[4] Espelhamento \n" + "[5] Escala Fixa \n" + "[6] Rotação Fixa \n" + "[7] Sair \n"
					+ "[8] Limpar Tela \n");

			opcao = input.nextInt();

			if (opcao == 0) {
				System.out.println("desenhar triangulo");
				t.equacao_diferecial(40, 70, 50, 50, t);
				t.equacao_diferecial(40, 55, 50, 90, t);
				t.equacao_diferecial(70, 55, 50, 90, t);
			}

			if (opcao == 1) {
				int ce;
				System.out.println("digite o valor do Coeficiente escalar");
				ce = input.nextInt();
				t.Escala(40, 70, 50, 50, t, ce);
				t.Escala(40, 55, 50, 90, t, ce);
				t.Escala(70, 55, 50, 90, t, ce);
			}

			if (opcao == 2) {
				double angulo;
				System.out.println("digite o valor do angulo");
				angulo = input.nextDouble();
				t.Rotacao(40, 70, 50, 50, t, angulo);
				t.Rotacao(40, 55, 50, 90, t, angulo);
				t.Rotacao(70, 55, 50, 90, t, angulo);
			}

			if (opcao == 3) {
				int tx, ty;
				System.out.println("digite o valor do Coeficiente de translatação de x");
				tx = input.nextInt();
				System.out.println("digite o valor do Coeficiente de translatação de y");
				ty = input.nextInt();

				t.Translatacao(40, 70, 50, 50, t, tx, ty);
				t.Translatacao(40, 55, 50, 90, t, tx, ty);
				t.Translatacao(70, 55, 50, 90, t, tx, ty);
			}

			if (opcao == 4) {
				System.out.println("desenhar triangulo invertido");
				t.espelhamento(40, 70, 50, 50, t);
				t.espelhamento(40, 55, 50, 90, t);
				t.espelhamento(70, 55, 50, 90, t);
			}

			if (opcao == 5) {
				int ce;
				System.out.println("digite o valor do Coeficiente escalar");
				ce = input.nextInt();
				t.Escala_fixa(40, 70, 50, 50, t, ce);
				t.Escala_fixa(40, 55, 50, 90, t, ce);
				t.Escala_fixa(70, 55, 50, 90, t, ce);
			}

			if (opcao == 6) {
				double angulo;
				System.out.println("digite o valor do angulo");
				angulo = input.nextDouble();
				t.Rotacao_fixa(40, 70, 50, 50, t, angulo);
				t.Rotacao_fixa(40, 55, 50, 90, t, angulo);
				t.Rotacao_fixa(70, 55, 50, 90, t, angulo);
			}

			if (opcao == 7) {
				System.exit(0);
			}
			if (opcao == 8) {
				t.limpar_tela();
			}
		}
	}
}
