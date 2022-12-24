package c_g;

import javax.swing.JFrame;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.Color;

public class draw extends JFrame {

	int height, width;

	public draw(int height, int width) {

		/* Torna possivel a visualização */
		setVisible(true);
		/* Encerra o programa ao terminar o processo */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/* Centraliza a imagem com base na tela */
		setLocationRelativeTo(null);
		/* Informa o tamanho da tela que está sedo usada */
		setSize(height, width);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int setWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void clean_screen() {

		/* Utiliza a resolução da tela que foi definida no construtor */
		Graphics g = getGraphics();
		/* Recurso da biblioteca que apaga o conteudo da tela */
		g.clearRect(0, 0, 10000, 10000);
	}

	public void general_equation() {

		/* Utiliza a resolução da tela que foi definida no construtor */
		Graphics g = getGraphics();
		int x, x0, xf, y0, yf, aux;
		float y, m;
		Scanner input = new Scanner(System.in);

		System.out.println("Informe o valor inicial de X");
		x0 = input.nextInt();
		System.out.println("Informe o valor inicial de Y");
		y0 = input.nextInt();
		System.out.println("Informe o valor final de X");
		xf = input.nextInt();
		System.out.println("Informe o valor final de y");
		yf = input.nextInt();

		aux = xf - x0;

		if (x0 == xf) {
			aux = 1;
		}

		m = (yf - y0) / (aux);
		for (x = x0; x <= xf; x++) {
			y = y0 + m * (x - x0);
			/* Define a cor que vai ser utilizada no desenho */
			g.setColor(Color.RED);
			/* Desenha o pixel na tela do programa */
			g.drawLine(x, Math.round(y), x, Math.round(y));

			if (x0 == xf) {
				x = x0;
				for (y = y0; y <= yf; y++) {
					/* Define a cor que vai ser utilizada no desenho */
					g.setColor(Color.RED);
					/* Desenha o pixel na tela do programa */
					g.drawLine(x, Math.round(y), x, Math.round(y));
				}
			}
		}
	}

	public void differential_equation() {

		/* Utiliza a resolução da tela que foi definida no construtor */
		Graphics g = getGraphics();
		int x, x0, xf, y0, yf, aux;
		float y, m;
		Scanner input = new Scanner(System.in);

		System.out.println("Informe o valor inicial de X");
		x0 = input.nextInt();
		System.out.println("Informe o valor inicial de Y");
		y0 = input.nextInt();
		System.out.println("Informe o valor final de X");
		xf = input.nextInt();
		System.out.println("Informe o valor final de y");
		yf = input.nextInt();

		aux = xf - x0;
		if (xf == x0) {
			aux = 1;
		}

		y = y0;
		m = (yf - y0) / (aux);
		for (x = x0; x <= xf; x++) {
			y = y + m;
			/* Define a cor que vai ser utilizada no desenho */
			g.setColor(Color.RED);
			/* Desenha o pixel na tela do programa */
			g.drawLine(x, Math.round(y), x, Math.round(y));
		}

		if (x0 == xf) {
			x = x0;
			for (y = y0; y <= yf; y++) {
				/* Define a cor que vai ser utilizada no desenho */
				g.setColor(Color.RED);
				/* Desenha o pixel na tela do programa */
				g.drawLine(x, Math.round(y), x, Math.round(y));
			}
		}
	}

	public void bresenhan_equation() {

		/* Utiliza a resolução da tela que foi definida no construtor */
		Graphics g = getGraphics();
		int x, x0, xf, y0, yf, p, y;
		float dx, dy, c1, c2;
		Scanner input = new Scanner(System.in);

		System.out.println("Informe o valor inicial de X");
		x0 = input.nextInt();
		System.out.println("Informe o valor inicial de Y");
		y0 = input.nextInt();
		System.out.println("Informe o valor final de X");
		xf = input.nextInt();
		System.out.println("Informe o valor final de y");
		yf = input.nextInt();

		dx = xf - x0;
		dy = yf - y0;
		p = (int) (2 * (dy - dx));
		c1 = 2 * dy;
		c2 = 2 * (dy - dx);
		y = y0;

		for (x = x0; x <= xf; x++) {
			if (p < 0) {
				p = (int) (p + c1);
			} else {
				p = (int) (p + c2);
				y = y + 1;
			}
			/* Define a cor que vai ser utilizada no desenho */
			g.setColor(Color.RED);
			/* Desenha o pixel na tela do programa */
			g.drawLine(x, y, x, y);
		}
		if (x0 == xf) {
			x = x0;
			for (y = y0; y <= yf; y++) {
				/* Define a cor que vai ser utilizada no desenho */
				g.setColor(Color.RED);
				/* Desenha o pixel na tela do programa */
				g.drawLine(x, Math.round(y), x, Math.round(y));
			}
		}

	}

	public void question_4() {

		/* Utiliza a resolução da tela que foi definida no construtor */
		Graphics g = getGraphics();
		int x, x0, xf, y0, yf, p, y;
		float dx, dy, c1, c2;
		Scanner input = new Scanner(System.in);

		System.out.println("Informe o valor inicial de X");
		x0 = input.nextInt();
		System.out.println("Informe o valor inicial de Y");
		y0 = input.nextInt();
		System.out.println("Informe o valor final de X");
		xf = input.nextInt();
		System.out.println("Informe o valor final de y");
		yf = input.nextInt();

		if (x0 == xf || y0 == yf) {

			dx = xf - x0;
			dy = yf - y0;
			p = (int) (2 * (dy - dx));
			c1 = 2 * dy;
			c2 = 2 * (dy - dx);
			y = y0;

			for (x = x0; x <= xf; x = x + 2) {
				if (p < 0) {
					p = (int) (p + c1);
				} else {
					p = (int) (p + c2);
					y = y + 2;
				}
				/* Define a cor que vai ser utilizada no desenho */
				g.setColor(Color.RED);
				/* Desenha o pixel na tela do programa */
				g.drawLine(x, y, x, y);

				if (x0 == xf) {
					x = x0;
					for (y = y0; y <= yf; y = y + 2) {
						/* Define a cor que vai ser utilizada no desenho */
						g.setColor(Color.RED);
						/* Desenha o pixel na tela do programa */
						g.drawLine(x, Math.round(y), x, Math.round(y));
					}
				}
			}
		} else {
			System.out.println("O VALOR INFORMADO É INCORRETO");
		}
	}

	public void question_5(int height, int width) {

		/* Utiliza a resolução da tela que foi definida no construtor */
		Graphics g = getGraphics();
		int x, x0, xf, y0, yf, y;
		Scanner input = new Scanner(System.in);

		x0 = 0;
		y0 = 0;
		xf = height;
		yf = width;

		for (y = y0; y <= yf; y += 10) {
			for (x = x0; x <= xf; x += 2) {
				/* Define a cor que vai ser utilizada no desenho */
				g.setColor(Color.RED);
				/* Desenha o pixel na tela do programa */
				g.drawLine(x, Math.round(y), x, Math.round(y));
			}
		}
		for (x = x0; x <= xf; x += 10) {
			for (y = y0; y <= yf; y += 2) {
				/* Define a cor que vai ser utilizada no desenho */
				g.setColor(Color.RED);
				/* Desenha o pixel na tela do programa */
				g.drawLine(x, Math.round(y), x, Math.round(y));
			}
		}

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int option;
		System.out.println("Informe a largura da tela a ser calculada");
		int width = input.nextInt();
		System.out.println("Informe a altura da tela a ser calculada");
		int height = input.nextInt();

		/* Inicia o processo de desenho no sistema */
		Draw d = new draw(height, width);
		d.setHeight(height);
		d.setWidth(width);

		while (true) {
			/* Imprime na tela do sistema os seguintes itens ao utilizador */
			System.out.printf(
					"[0] LIMPAR TELA \n" +
							"[1] ALGORITMO RETA: EQUACAO GERAL \n" +
							"[2] ALGORITMO RETA: EQUACAO DIFERENCIAL \n" +
							"[3] ALGORITMO RETA: BRESENHAN \n" +
							"[4] QUESTAO 4 \n" +
							"[5] QUESTAO 5 \n" +
							"[6] SAIR DO PROGRAMA \n");

			/* Retorna o que o utilizador escolheu no sistema */
			option = input.nextInt();

			if (option == 0) {
				System.out.println(" Limpar tela ");
				d.clean_screen();
			}
			if (option == 1) {
				System.out.println(" Equação geral ");
				d.general_equation();
			}
			if (option == 2) {
				System.out.println(" Equação diferencial ");
				d.differential_equation();
			}
			if (option == 3) {
				System.out.println(" Bresenhan ");
				d.bresenhan_equation();
			}
			if (option == 4) {
				d.question_4();
			}
			if (option == 5) {
				d.question_5(height, width);
			}
			if (option == 6) {
				System.exit(0);
			}
		}
	}
}