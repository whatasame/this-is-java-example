package ch19.sec06;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParseJsonExample {

    public static void main(String[] args) throws IOException {

        // json 읽기
        BufferedReader bufferedReader = new BufferedReader(
//                new FileReader("./out/member.json", Charset.forName("UTF-8"))
                new FileReader("./out/member.json")
        );
        String json = bufferedReader.readLine();
        bufferedReader.close();

        // parse json
        JSONObject root = new JSONObject(json);

        // parse 속성
        System.out.println("id: " + root.getString("id"));
        System.out.println("name: " + root.getString("name"));
        System.out.println("age: " + root.getInt("age"));
        System.out.println("student: " + root.getBoolean("student"));

        // parse 객체
        JSONObject tel = root.getJSONObject("tel");
        System.out.println("home: " + tel.getString("home"));
        System.out.println("mobile: " + tel.getString("mobile"));

        // parse 배열
        JSONArray skill = root.getJSONArray("skill");
        System.out.println("skill: ");
        for (int i = 0; i < skill.length(); i++) {
            System.out.print(skill.get(i) + ", ");
        }

    }

}
