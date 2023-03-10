package Computação_grafica;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;

public class Elipse extends JFrame {

	int alt, larg;
	Graphics g;

	public Elipse(int alt, int larg) {
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

	public void limpar_tela(Elipse e) {

		Graphics g = getGraphics();
		g.clearRect(0, 0, e.getLarg(), e.getAlt());

	}

	public void Cria_elipse(int raiox, int raioy, Elipse e) {

		Graphics g = getGraphics();

		int x, y, alt, larg;
		alt = e.getAlt();
		larg = e.getLarg();
		x = larg / 2;
		y = alt / 2;

		int xc = 0;
		int yc = raioy;

		int p;
		double auxp;

		p = raioy * raioy - raiox * raiox * raioy + raiox * raiox / 4;

		while (2 * raioy * raioy * xc <= 2 * raiox * raiox * yc) {
			g.drawLine(x + xc, y + yc, x + xc, y + yc);
			g.drawLine(x - xc, y + yc, x - xc, y + yc);
			g.drawLine(x + xc, y - yc, x + xc, y - yc);
			g.drawLine(x - xc, y - yc, x - xc, y - yc);

			if (p < 0) {
				xc++;
				p = p + 2 * raioy * raioy * xc + raioy * raioy;
			} else {
				xc++;
				yc--;
				p = p + 2 * raioy * raioy * xc - 2 * raiox * raiox * yc - raioy * raioy;
			}
		}

		auxp = raioy * raioy * (xc + 0.5) * (xc + 0.5) + raiox * raiox * (yc - 1) * (yc - 1)
				- raiox * raiox * raioy * raioy;

		while (yc >= 0) {
			g.drawLine(x + xc, y + yc, x + xc, y + yc);
			g.drawLine(x - xc, y + yc, x - xc, y + yc);
			g.drawLine(x + xc, y - yc, x + xc, y - yc);
			g.drawLine(x - xc, y - yc, x - xc, y - yc);

			if (auxp > 0) {
				yc--;
				auxp = auxp - 2 * raiox * raiox * yc + raiox * raiox;
			} else {
				xc++;
				yc--;
				auxp = auxp + 2 * raioy * raioy * xc - 2 * raiox * raiox * yc - raiox * raiox;
			}
		}
	}

	public void preencher(int raiox, int raioy, Elipse e) {

		for (int aux = 0; aux < raiox || aux < raioy; raiox--, raioy--) {
			Graphics g = getGraphics();

			int x, y, alt, larg;
			alt = e.getAlt();
			larg = e.getLarg();
			x = larg / 2;
			y = alt / 2;

			int xc = 0;
			int yc = raioy;

			int p;
			double auxp;

			p = raioy * raioy - raiox * raiox * raioy + raiox * raiox / 4;

			while (2 * raioy * raioy * xc <= 2 * raiox * raiox * yc) {
				g.drawLine(x + xc, y + yc, x + xc, y + yc);
				g.drawLine(x - xc, y + yc, x - xc, y + yc);
				g.drawLine(x + xc, y - yc, x + xc, y - yc);
				g.drawLine(x - xc, y - yc, x - xc, y - yc);

				if (p < 0) {
					xc++;
					p = p + 2 * raioy * raioy * xc + raioy * raioy;
				} else {
					xc++;
					yc--;
					p = p + 2 * raioy * raioy * xc - 2 * raiox * raiox * yc - raioy * raioy;
				}
			}

			auxp = raioy * raioy * (xc + 0.5) * (xc + 0.5) + raiox * raiox * (yc - 1) * (yc - 1)
					- raiox * raiox * raioy * raioy;

			while (yc >= 0) {
				g.drawLine(x + xc, y + yc, x + xc, y + yc);
				g.drawLine(x - xc, y + yc, x - xc, y + yc);
				g.drawLine(x + xc, y - yc, x + xc, y - yc);
				g.drawLine(x - xc, y - yc, x - xc, y - yc);

				if (auxp > 0) {
					yc--;
					auxp = auxp - 2 * raiox * raiox * yc + raiox * raiox;
				} else {
					xc++;
					yc--;
					auxp = auxp + 2 * raioy * raioy * xc - 2 * raiox * raiox * yc - raiox * raiox;
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int opcao, raiox, raioy;
		System.out.println("digite a largura da sua tela");
		int larg = input.nextInt();
		System.out.println("digite a altura da sua tela");
		int alt = input.nextInt();

		Elipse e = new Elipse(alt, larg);

		e.setAlt(alt);
		e.setLarg(larg);

		while (true) {

			System.out.printf("[0] Limpa tela \n" + "[1] Desenha elipse \n"
					+ "[2] preenchimento \n" + "[3] sair \n");

			opcao = input.nextInt();

			if (opcao == 0) {
				e.limpar_tela(e);
			}
			if (opcao == 1) {
				System.out.println("digite o valor do raio do eixo x");
				raiox = input.nextInt();
				System.out.println("digite o valor do raio do eixo y");
				raioy = input.nextInt();

				e.Cria_elipse(raiox, raioy, e);
			}
			if (opcao == 2) {
				System.out.println("digite o valor do raio do eixo x");
				raiox = input.nextInt();
				System.out.println("digite o valor do raio do eixo y");
				raioy = input.nextInt();

				e.preencher(raiox, raioy, e);
			}
			if (opcao == 3) {
				System.exit(0);
			}
		}
	}

}
