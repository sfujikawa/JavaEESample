/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
//import javax.ejb.EJB;

/**
 *
 * @author sunfuji
 */
public class ForSample {

    //@EJB
    //NewFnc newFnc;
    
    public static void sample() {

        List<String> strs = Arrays.asList("aaa", "bbb", "ccc");

        //ラムダ式を使ってfor文を簡素に書く。
        // 昔の書き方
        System.out.println("for文:");
        for (int i = 0; i < strs.size(); i++) {
            System.out.println(strs.get(i));
        }

        // 今風な書き方　se7まで
        System.out.println("拡張for文:");
        for (String s : strs) {
            System.out.println(s);
        }

        // ラムダ式(関数自体を引数として渡す)
        System.out.println("Lambda式:");
        strs.forEach(s -> System.out.println(s));
	// 拡張forにくらべ、型推測により、型の記載(上の例だとString s)が不要になった
        // またforEachの引数であるカッコ内は、「関数」。引数に関数を渡すことができる。
        //   s  :パラメータ     strs内の要素をsという名前の編集として引き渡す。
        //   -> :アロー        右に関数を記載する。

        // メソッド参照
        System.out.println("ラムダ式+メソッド参照");
        strs.forEach(System.out::println);
        //メソッド参照: パラメータと引き渡すメソッドの引数の型、数が同じ場合のみ パラメータの宣言も不要となる
        // どのように処理させるかでなく、何を実現させるか　に視点を置くようなコーディン手法となる.

        //補足
        // そもそもforEachでなにができるか
        System.out.println("そもそもforEach:");
        strs.forEach(
                new Consumer<String>() {
                    @Override
                    public void accept(String str) {
                        System.out.println(str);
                    }
                }
        );
	// 配列に対して　繰り返し処理させるための手法
        // Java8からIterableインターフェスにforEachメソッドが追加された。
        // Consumerは関数型インターフェースであること

        // printlnじゃなくて実際の使い方
        // 
        // データベースの検索結果全件に対して、同様の処理を行いたい場合など
        // 処理をメソッド(スタティックである必要あり)にし、引数として引き渡す。
        // ・1行で書けるようになった。
        // ・処理速度が早い。
        System.out.println("他のクラスのスタティックメソッド1:");
        strs.forEach(s -> Fnc.staticDisplay(s));

        System.out.println("他のクラスのスタティックメソッド2:");
        strs.forEach(Fnc::staticDisplay);

        Fnc f = new Fnc();
        System.out.println("他のクラスのインスタンスメソッド1:");
        strs.forEach(s -> f.display(s));
        //次
        //CDI,EJBを利用してEEっぽくする。
        //System.out.println("CDIのクラスのインスタンスメソッド1:");
        //strs.forEach(s -> newFnc.staticDisplay(s));
    }
}
