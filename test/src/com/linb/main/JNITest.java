package com.linb.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.tls.sigcheck.tls_sigcheck;

public class JNITest {
    public static void main(String args[]) throws Exception {
        File file = new File("Graphics/jnisigcheck.dll");
        String path = file.getAbsolutePath();
        path = path.replace("\\", "\\\\");
        tls_sigcheck demo = new tls_sigcheck();
        System.out.println("C:\\Users\\ucmed\\Desktop\\tls_sig_api-windows-64\\lib\\jni\\jnisigcheck.dll");
        // 使用前请修改动态库的加载路径
        demo.loadJniLib(path);
        // demo.loadJniLib("/home/tls/tls_sig_api/src/jnisigcheck.so");

        File priKeyFile = new File("Graphics/ec_key.pem");
        StringBuilder strBuilder = new StringBuilder();
        String s = "";

        BufferedReader br = new BufferedReader(new FileReader(priKeyFile));
        while((s = br.readLine()) != null) {
            strBuilder.append(s + '\n');
        }
        br.close();
        String priKey = strBuilder.toString();
        // String priKey = "MHQCAQEEIGh0ZGZpftUUfgCyhlrBfgcASMla9RoRRk6GY8jLV2W2oAcGBSuBBAAKoUQDQgAEucWJGkV8W4dsF+d5lKYsXRuK5Qrbzlm/CZY5b47RlUUedLVl8Cf/gZSQmDqg5H95t4hC5ACIkQ10QTmwMltuMg==";
        int ret = demo.tls_gen_signature_ex2("1400000267", "xiaojun",
                priKey);

        if(0 != ret) {
            System.out.println("ret " + ret + " " + demo.getErrMsg());
        } else {
            System.out.println("sig:\n" + demo.getSig());
        }

        File pubKeyFile = new File("Graphics/public.pem");
        br = new BufferedReader(new FileReader(pubKeyFile));
        strBuilder.setLength(0);
        while((s = br.readLine()) != null) {
            strBuilder.append(s + '\n');
        }
        br.close();
        String pubKey = strBuilder.toString();
        // String pubKey = "MFYwEAYHKoZIzj0CAQYFK4EEAAoDQgAEucWJGkV8W4dsF+d5lKYsXRuK5Qrbzlm/CZY5b47RlUUedLVl8Cf/gZSQmDqg5H95t4hC5ACIkQ10QTmwMltuMg==";
        ret = demo.tls_check_signature_ex2(demo.getSig(), pubKey,
                "1400000267", "xiaojun");
        if(0 != ret) {
            System.out.println("ret " + ret + " " + demo.getErrMsg());
        } else {
            System.out.println("--\nverify ok -- expire time "
                    + demo.getExpireTime() + " -- init time "
                    + demo.getInitTime());
        }
    }
}
