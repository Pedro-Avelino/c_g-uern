package Computação_grafica;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;

public class Poligono extends JFrame {

	int alt, larg;
	Graphics g;

	private int[] Pontos_x = { 200, 200, 250, 270, 300 };
	private int[] Pontos_y = { 300, 200, 250, 200, 300 };
	private int Pontos_n = 5;

	public Poligono(int alt, int larg) {
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

	public void limpar_tela(Poligono p) {

		Graphics g = getGraphics();
		g.clearRect(0, 0, p.getLarg(), p.getAlt());

	}

	public void desenhar() {
		Graphics g = getGraphics();

		Polygon poly = new Polygon(Pontos_x, Pontos_y, Pontos_n);

		for (int i = 0; i < Pontos_n; i++) {
			int x2 = Pontos_x[i];
			int y2 = Pontos_y[i];
			int x3 = Pontos_x[(i + 1) % Pontos_n];
			int y3 = Pontos_y[(i + 1) % Pontos_n];
			g.drawLine(x2, y2, x3, y3);
		}
	}

	public void pintar() {
		Graphics g = getGraphics();

		Polygon poly = new Polygon(Pontos_x, Pontos_y, Pontos_n);

		int[] scan = new int[getSize().width];

		int minY = poly.getBounds().y;
		int maxY = minY + poly.getBounds().height;

		for (int y = minY; y < maxY; y++) {
			Arrays.fill(scan, 0);
			int x1 = Integer.MAX_VALUE;

			for (int i = 0; i < Pontos_n; i++) {
				int x2 = Pontos_x[i];
				int y2 = Pontos_y[i];
				int x3 = Pontos_x[(i + 1) % Pontos_n];
				int y3 = Pontos_y[(i + 1) % Pontos_n];

				if ((y2 < y && y3 >= y) || (y3 < y && y2 >= y)) {
					int x = x2 + (y - y2) * (x3 - x2) / (y3 - y2);
					scan[x]++;

					if (x < x1) {
						x1 = x;
					}
				}
			}

			boolean fora = false;

			for (int x = x1; x < getSize().width; x++) {
				if (scan[x] % 2 == 1) {
					fora = !fora;
				}

				if (fora) {
					g.drawLine(x, y, x, y);
				}
			}

		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int opcao;

		System.out.println("digite a largura da sua tela");
		int larg = input.nextInt();
		System.out.println("digite a altura da sua tela");
		int alt = input.nextInt();

		Poligono p = new Poligono(alt, larg);

		p.setAlt(alt);
		p.setLarg(larg);

		while (true) {

			System.out.printf("[0] Limpa tela \n" + "[1] Desenha \n"
					+ "[2] preenchimento \n" + "[3] sair \n");

			opcao = input.nextInt();

			if (opcao == 0) {
				p.limpar_tela(p);
			}
			if (opcao == 1) {
				System.out.println("Poligono desenhado");

				p.desenhar();

			}
			if (opcao == 2) {
				System.out.println("Poligono desenhado");
				p.pintar();
			}
			if (opcao == 3) {
				System.exit(0);
			}

		}
	}
}
