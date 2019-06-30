package xyz.lilei.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @ClassName TestStream
 * @Description TODO
 * @Author lilei
 * @Date 20/06/2019 16:52
 * @Version 1.0
 **/
public class TestStream {

    public static void main(String[] args) throws InterruptedException {
           Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
           List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
           List<Integer> parallelStorage = new ArrayList<>();//Collections.synchronizedList(new ArrayList<>());
           listOfIntegers .parallelStream() // Don't do this! It uses a stateful lambda expression. .
                .forEachOrdered(e -> System.out.print(e + " "));
           System.out.println();
           parallelStorage.stream()
                .forEachOrdered(e -> System.out.print(e + " "));
           System.out.println(); System.out.println("Sleep 5 sec");
           TimeUnit.SECONDS.sleep(5); parallelStorage .stream() .forEachOrdered(e -> System.out.print(e + " "));
           }
           private static List<String> words = Arrays.asList("hello world",
                "hello java",
                "hello hello");
           private static List<String> wordList = Arrays.asList("aa","bb","cc");

        @Test
        public void test1(){
            words.stream()
                    //对words的每一项都做切割操作，把每一个字符串都转换为数组
                    //执行完后数据结构如下{["hello","world"],["hello","java"],["hello","hello"]}
                    .map(item -> item.split(" "))
                    //对每个数组做单独的遍历操作
                    .forEach(arr->{
                        for(String item : arr){
                            System.out.println(item);
                        }
                    });
        }

        @Test
        public void test2(){
            words.stream()
                    //把每一项转化为数组包含列表的Stream流
                    //然后这个函数把所有的List里面的字符串都取出来放在了一个集合中，这个集合做下一次执行的数据源
                    //{"hello","world","hello","java","hello","hello"}
                    .flatMap(item->{
                        String[] arr = item.split(" ");
                        return Arrays.asList(arr).stream();
                    })
                    //根据每一项的HashCode和equals方法做去重操作
                    .distinct()
                    //打印每一项
                    .forEach(item->System.out.println(item));
        }

        @Test
        public void test3(){
            wordList.stream()
                    //把T1的getCharacter方法应用于wordList的每一项,wordList每一项都是String
                    //getCharacter方法的参数也是String，符合函数式接口
                    //通过map方法就把wordList的每一项都转换为了存放单个字符(以字符串的形式存放)列表的Stream流即Stream<List<String>>
                    .map(TestStream::getCharacter)
                    //对转换后的每一项(List)分别做遍历操作
                    .forEach(sm->{
                        sm.forEach(System.out::println);
                    });
        }

        @Test
        public void test4(){
            wordList.stream()
                    .flatMap(TestStream::getCharacter)
                    .distinct()
                    .forEach(System.out::println);
        }

        public static Stream<String> getCharacter(String str){
            char[] array = str.toCharArray();
            List<String> list = new ArrayList<String>();

            for(char item : array){
                list.add(String.valueOf(item));
            }
            Stream<String> stream = list.stream();
            return stream;
        }
    }


