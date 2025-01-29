package com.example.todo;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.todo.db.AppDatabase;
import com.example.todo.db.Task;
import com.example.todo.db.TaskDao;

import java.io.IOException;
import java.util.List;


@RunWith(AndroidJUnit4.class)
public class DatabaseConnectionTest {
    private TaskDao taskDao;
    private AppDatabase db;

    @Before
    public void SetUp(){
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        taskDao = db.taskDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void DatabaseTest() {
        Task task = new Task();
        task.setTaskId(1);
        task.setTaskText("test");
        taskDao.insert(task);
        List<Task> tasks = taskDao.getAll();
        assertEquals(1, tasks.size());
        assertEquals("test", tasks.get(0).getTaskText());
    }
}