package lab14;

import lab14lib.*;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {


		Generator generator = new lab14.StrangeBitwiseGenerator(1024);
		GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(generator);
		gav.drawAndPlay(128000, 1000000);


		/*
		Generator generator = new lab14.SawToothGenerator(512);
		GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(generator);
		gav.drawAndPlay(4096, 1000000);
        */


		/*
		Generator generator = new SineWaveGenerator(440);
		GeneratorPlayer gp = new GeneratorPlayer(generator);
		gp.play(1000000);
		*/

		/*
		Generator generator = new SineWaveGenerator(200);
		GeneratorDrawer gd = new GeneratorDrawer(generator);
		gd.draw(4096);
        */

		/*
		Generator generator = new SineWaveGenerator(200);
		GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(generator);
		gav.drawAndPlay(4096, 1000000);
        */

		/*
		Generator g1 = new SineWaveGenerator(60);
		Generator g2 = new SineWaveGenerator(61);

		ArrayList<Generator> generators = new ArrayList<Generator>();
		generators.add(g1);
		generators.add(g2);
		MultiGenerator mg = new MultiGenerator(generators);

		GeneratorAudioVisualizer gav = new GeneratorAudioVisualizer(mg);
		gav.drawAndPlay(500000, 1000000);
        */

	}


} 