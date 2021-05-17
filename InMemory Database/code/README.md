The objective is to design and implement an in-memory SQL-like database, which should support the following set of operations / functionality:
It should be possible to-
    \n create or delete tables in a database.
    \n A table definition comprises columns which have types. They can also have constraints
    \n The supported column types are string and int.
    \n The string type can have a maximum length of 20 characters.
    \n The int type can have a minimum value of -1024 and a maximum value of 1024.
    \n Support for mandatory fields (tagging a column as required)
    \n It should be possible to insert records in a table.
    \n It should be possible to print all records in a table.
    \n It should be possible to filter and display records whose column values match a given value.
