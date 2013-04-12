package ru.ttk.clojure;

import clojure.lang.IFn;
import clojure.lang.RT;
import clojure.lang.Var;

import java.io.IOException;

/**
 *
 */
public class TryRunTimeClojure {

    public static void main(String... args) throws IOException {

        String script = "(ns ru.ttk.clojure.core\n" +
                "  (:import\n" +
                "    [org.joda.time DateTime]\n" +
                "    [java.util Date]\n" +
                "    [java.text SimpleDateFormat]))\n" +
                "\n" +
                "(defn current-time []\n" +
                "  (DateTime. ))";

        System.out.println(TryRunTimeClojure.class.getPackage());

        RT.loadResourceScript("go/tt.clj");
        Object obj = RT.var("go.tt", "currenttime").invoke();
        System.out.println(obj);

        obj = RT.var("go.tt", "square").invoke(5);
        System.out.println(obj);

    }

}


//RT.loadResourceScript("clojure_script.clj");
//Var report = RT.var("clj.script.examples", "print-report");
//Integer result = (Integer) report.invoke("Siva");
//System.out.println("Result: " + result);
