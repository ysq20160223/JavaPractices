package bh.day_08.t06;

import utils.XLog;

/*
 * 多态的练习
 */

public class Day0806 {

	public static void main(String[] args) {
		MainBoard mb = new MainBoard();
		// mb.run();

		mb.usePCI(new NetCard());
	}

}

class MainBoard {

	public void run() {
		XLog.init().debug("MainBoard Run");
	}

	public void usePCI(PCI pci) {
		pci.run();
	}

}

interface PCI {
	public void run();
}

class NetCard implements PCI {

	public void run() {
		XLog.init().debug("NetCard Run");
	}

}
