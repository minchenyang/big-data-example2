package com.min.hadoopexample;

import org.apache.hadoop.fs.FileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HadoopExampleApplication implements CommandLineRunner {

    @Autowired
	org.springframework.data.hadoop.fs.FsShell fsShell;

	public static void main(String[] args) {
		SpringApplication.run(HadoopExampleApplication.class, args);

	}

	@Override
	public void run(final String... args) throws Exception {
		/*CRUDExample crudExample = new CRUDExample();
		try {
			crudExample.copyToLocalFile();


		} catch (Exception e) {
			e.printStackTrace();
		}*/

		// 查看根目录下的所有文件
		for (FileStatus fileStatus : fsShell.ls("/")) {
			System.out.println("> " + fileStatus.getPath());
		}

	}
}
