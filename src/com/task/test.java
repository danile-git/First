package com.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

//ssh $x
// "su $TOUSER -c 'source ${PPATH} ;nohup storm supervisor  > /tmp/storm_log 2>&1 &' "
// for pid in $(ssh $x ps -ef | grep storm |awk '{print $2}')
// do
// echo "-----$x  $pid"
// done
public class test {
	public static void main(String[] args) throws Exception {
		String host_name = "node2";
		ShellUtil shellUtil = new ShellUtil();

		// StringBuilder stringBuilder = new StringBuilder();
		// stringBuilder.append("ssh ");
		// stringBuilder.append(host_name);
		// stringBuilder.append(" \"su hadoop -c 'source /etc/profile ;storm supervisor' \"");
		// String[] cmds = {"/bin/sh","-c","ps -ef|grep java"};
		// // String[] cmds = {"/bin/sh","-c",stringBuilder.toString()};
		// Process pro = Runtime.getRuntime().exec(cmds);
		// pro.waitFor();
		// InputStream in = pro.getInputStream();
		// BufferedReader read = new BufferedReader(new InputStreamReader(in));
		// String line = null;
		// while((line = read.readLine())!=null){
		// System.out.println(line);
		// }
		//
		// ssh $x
		// "su $TOUSER -c 'source ${PPATH} ;nohup storm supervisor  > /tmp/storm_log 2>&1 &' "

		// StringBuilder stringBuilder = new StringBuilder();
		// stringBuilder.append("ssh ");
		// stringBuilder.append(host_name);
		// stringBuilder.append(" ps -ef|grep ");
		// stringBuilder.append("storm");
		// stringBuilder.append(" |awk '{print $2}'");
		// // stringBuilder.append(" ssh ");
		// // stringBuilder.append(host_name);
		// // stringBuilder.append(" kill -9 $pid");
		// // stringBuilder.append(" done");
		//
		
	
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("ssh ");
			stringBuilder.append(host_name);
			stringBuilder.append(" ps -ef | grep ");
			stringBuilder.append("storm");
			stringBuilder.append(" |awk '{print $2}'");
			System.out.println(msg_to_string( shellUtil.execShell(stringBuilder.toString())));
		
		
//		StringBuilder stringBuilder = new StringBuilder();
//		stringBuilder.append("ssh ");
//		stringBuilder.append(host_name);
//		stringBuilder.append(" \"su hadoop -c 'source /etc/profile ;storm supervisor' \"&");
//		ShellUtil shellUtil = new ShellUtil();
//		List<String> list = shellUtil.execShell(stringBuilder.toString());
//		System.out.println(msg_to_string(list));
		//StringBuilder spid = new StringBuilder();

		// for (String string : list) {
		// spid.append("ssh ");
		// spid.append(host_name);
		// spid.append(" kill -9 ");
		// spid.append(string);
		// spid.append("\n");
		// }
		// if (spid.length() > 1) {
		// List<String> lilList = shellUtil.execShell(spid.toString());
		// for (String string : lilList) {
		// System.out.println(string);
		// }
		// }

	}

	private static String msg_to_string(List<String> msg) {
		String str = "";
		for (String string : msg) {
			str += string + "\n";
		}
		return str;
	}
}
