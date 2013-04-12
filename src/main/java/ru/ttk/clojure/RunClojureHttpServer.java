package ru.ttk.clojure;

import clojure.lang.RT;

import java.io.IOException;
import java.io.Serializable;

/**
 * Date: 4/12/13
 * Time: 6:42 PM
 *
 * @author konilovsky
 * @since 1.0
 */
public class RunClojureHttpServer implements Serializable {

    public static void main(String... args) throws IOException {
        RT.loadResourceScript("go/srv.clj");
        RT.var("go.srv", "srvr2").invoke(5000);
        System.out.println("Server started at 5000");
    }

}
