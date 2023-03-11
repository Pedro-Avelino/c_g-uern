package Computação_grafica;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;

public class Circulo extends JFrame {

	int alt, larg;
	Graphics g;

	public Circulo(int alt, int larg) {
		setSize(larg, alt);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

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

	public void limpar_tela(Circulo c) {

		Graphics g = getGraphics();
		g.clearRect(0, 0, c.getLarg(), c.getAlt());

	}

	public void circulo_parametrico(int r, Circulo c) {

		Graphics g = getGraphics();

		int y, x, xc, yc, alt, larg;
		double t;
		alt = c.getAlt();
		larg = c.getLarg();
		xc = larg / 2;
		yc = alt / 2;

		x = r;
		y = 0;

		for (t = 1; t < 360; t = t + 0.1) {
			g.setColor(Color.BLACK);
			g.drawLine(x + xc, y + yc, x + xc, y + yc);
			x = (int) (r * Math.cos(Math.PI * t / 180));
			y = (int) (r * Math.sin(Math.PI * t / 180));
		}

	}

	public void ordem_oito(int x, int y, int xc, int yc) {
		Graphics g = getGraphics();
		g.setColor(Color.BLACK);
		g.drawLine(x + xc, y + yc, x + xc, y + yc);
		g.drawLine(y + xc, x + yc, y + xc, x + yc);
		g.drawLine(-y + xc, x + yc, -y + xc, x + yc);
		g.drawLine(-x + xc, y + yc, -x + xc, y + yc);
		g.drawLine(-x + xc, -y + yc, -x + xc, -y + yc);
		g.drawLine(-y + xc, -x + yc, -y + xc, -x + yc);
		g.drawLine(y + xc, -x + yc, y + xc, -x + yc);
		g.drawLine(x + xc, -y + yc, x + xc, -y + yc);

	}

	public void Circulo_Ponto_Medio(int raio, Circulo c) {
		int xc, yc, larg, alt;
		alt = c.getAlt();
		larg = c.getLarg();
		xc = larg / 2;
		yc = alt / 2;
		int x = 0;
		int y = raio;
		double d = 5 / 4 - raio;
		ordem_oito(x, y, xc, yc);
		while (y > x) {
			if (d < 0) {
				d = d + 2 * x + 3;
			} else {
				d = d + 2 * (x - y) + 5;
				y--;
			}
			x++;
			ordem_oito(x, y, xc, yc);
		}
	}

	public void preencher(int raio, Circulo c) {
		for (double auxraio = 0; auxraio < raio; auxraio = auxraio + 0.1) {
			int xc, yc, larg, alt;
			alt = c.getAlt();
			larg = c.getLarg();
			xc = larg / 2;
			yc = alt / 2;
			int x = 0;
			int y = (int) auxraio;
			double d = 5 / 4 - auxraio;
			ordem_oito(x, y, xc, yc);
			while (y > x) {
				if (d < 0) {
					d = d + 2 * x + 3;
				} else {
					d = d + 2 * (x - y) + 5;
					y--;
				}
				x++;
				ordem_oito(x, y, xc, yc);
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcao, raio;
		System.out.println("digite a largura da sua tela");
		int larg = input.nextInt();
		System.out.println("digite a altura da sua tela");
		int alt = input.nextInt();

		Circulo c = new Circulo(alt, larg);

		c.setAlt(alt);
		c.setLarg(larg);

		while (true) {

			System.out.printf("[0] Limpa tela \n" + "[1] Desenha Circulo \n" + "[2] ponto medio \n"
					+ "[3] preenchimento \n" + "[4] sair \n");

			opcao = input.nextInt();

			if (opcao == 0) {
				c.limpar_tela(c);
			}
			if (opcao == 1) {
				System.out.println("digite um raio");
				raio = input.nextInt();
				c.circulo_parametrico(raio, c);
			}
			if (opcao == 2) {
				System.out.println("digite um raio");
				raio = input.nextInt();
				c.Circulo_Ponto_Medio(raio, c);
			}

			if (opcao == 3) {
				System.out.println("digite um raio");
				raio = input.nextInt();
				c.preencher(raio, c);
			}
			if (opcao == 4) {
				System.exit(0);
			}
		}
	}
}
