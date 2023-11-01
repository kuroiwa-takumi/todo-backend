package com.kuroiwa.todo.presentation.controller;

import com.kuroiwa.todo.presentation.generated.api.*;
import com.kuroiwa.todo.presentation.generated.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/kuroiwa-todo/v1")
public class TodosApiController implements TodoListApi {

    @Override
    public ResponseEntity<GetTodoItemsResponse> todoListGet(String userToken) {
        // ダミーデータを作成
        final Todo todo1 = new Todo()
                .todoUuid(1)
                .title("買い物をする")
                .description("野菜と肉を購入")
                .completed(false);

        final Todo todo2 = new Todo()
                .todoUuid(2)
                .title("犬の散歩")
                .description("公園まで連れて行く")
                .completed(false);

        final Todo todo3 = new Todo()
                .todoUuid(3)
                .title("宿題を終わらせる")
                .description("数学の宿題")
                .completed(false);

        final List<Todo> dummyTodos = Arrays.asList(todo1, todo2, todo3);

        // ダミーデータをレスポンスオブジェクトに格納
        final GetTodoItemsResponse response = new GetTodoItemsResponse().todos(dummyTodos);

        // ResponseEntity にラップしてレスポンスを返す
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
