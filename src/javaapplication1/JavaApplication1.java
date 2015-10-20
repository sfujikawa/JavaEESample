package javaapplication1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class JavaApplication1 {

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("aaa", "bbb", "ccc");

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

	// 拡張forにくらべ、型推測により、型の記載が不要
        // またforEachの引数であるカッコ内は、「関数」。引数に関数を渡している。
        // s :パラメータ
        // -> :アロー
        // System.out.println("Lambda式:" + s):関数本体
        // メソッド参照
        System.out.println("ラムダ式+メソッド参照");
        strs.forEach(System.out::println);

	// ラムダ式+メソッド参照(パラメータと引き渡すメソッドの引数の型、数が同じ場合のみ)
        // どのように処理させるかでなく、何を実現させるか　を記載するようになった
        // そもそもforEachでなにができるか
        System.out.println("forEach:");
        strs.forEach(new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        });
	// 配列に対して　繰り返し処理させるための手法
        // Java8からIterableインターフェスにforEachメソッドが追加された。
        // Consumerは関数型インターフェース

	// 他のクラスのメソッド　スタティックである必要あり
        // データベースの検索結果全件に対して、同様の処理を行いたい。関数を引数に渡して1行で実行できる。
        // 処理速度も早い。
        System.out.println("他のクラスのスタティックメソッド1:");
        strs.forEach(s -> Fnc.staticDisplay(s));
        System.out.println("他のクラスのスタティックメソッド2:");
        strs.forEach(Fnc::staticDisplay);

        Fnc f = new Fnc();
        System.out.println("他のクラスのインスタンスメソッド1:");
        strs.forEach(s -> f.display(s));
        
        
        //次
        //CDI,EJBを利用してEEっぽくする。
        

    }

}

