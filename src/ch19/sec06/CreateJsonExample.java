package ch19.sec06;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CreateJsonExample {

    public static void main(String[] args) throws IOException {
        // json 객체 root 생성
        JSONObject root = new JSONObject();

        // root에 Key-Value 추가
        root.put("id", "winter");
        root.put("name", "한겨울");
        root.put("age", 25);
        root.put("student", true);

        // json 객체 tel 생성 후 Key-Value 추가
        JSONObject tel = new JSONObject();
        tel.put("home", "02-123-1234");
        tel.put("mobile", "010-123-1234");

        root.put("tel", tel); // 객체 안에 객체가 들어갈 수 있다.

        // array 객체
        JSONArray skill = new JSONArray();
        skill.put("java");
        skill.put("c");
        skill.put("c++");
        root.put("skill", skill); // "skill": {"java", "c", "c++"}

        // 만든 json을 String으로 얻기
        String json = root.toString();
        System.out.println(json);

        // 파일로 저장
//        Writer writer = new FileWriter("./out/member.json", Charset.forName("UTF-8")); // JDK 8에선 없는 생성자
        Writer writer = new FileWriter("./out/member.json");
        writer.write(json);
        writer.flush();
        writer.close();

    }


}
