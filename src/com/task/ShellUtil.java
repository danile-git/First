package com.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ShellUtil {

	// String[] cmds = {"/bin/sh","-c","ps -ef|grep java"};
	// Process pro = Runtime.getRuntime().exec(cmds);
	// pro.waitFor();
	// InputStream in = pro.getInputStream();
	// BufferedReader read = new BufferedReader(new InputStreamReader(in));
	// String line = null;
	// while((line = read.readLine())!=null){
	// System.out.println(line);
	// }
	//
	/**
	 * 执行shell命令
	 * */
	public List<String> execShell(String cmd) {
		String[] cmds = { "/bin/sh", "-c", cmd };
		Process process;
		try {
			process = Runtime.getRuntime().exec(cmds);
			process.waitFor();
			return console(process);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return new ArrayList<String>();
	}

	/**
	 * 输出信息
	 * */
	private List<String> console(Process process) throws IOException {
		InputStream in = process.getInputStream();
		BufferedReader read = new BufferedReader(new InputStreamReader(in));
		String line = null;
		List<String> list = new ArrayList<String>();
		while ((line = read.readLine()) != null) {
			list.add(line);
		}
		return list;
	}

}
