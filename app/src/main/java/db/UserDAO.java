package db;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert
    void insert(User user);

    @Insert
    long[] insertAll(User... user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}
