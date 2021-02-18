
//https://www.youtube.com/watch?v=ThbkV4Fs7iE
//LeetCode 1280: Students and Examinations - Interview Prep Ep 23
//https://github.com/fishercoder1534/Leetcode/blob/master/database/_1280.sql

select a.student_id, a.student_name, b.subject_name, count(c.subject_name) as attended_exams
from Students as a
join Subjects as b
left join Examinations as c
on a.student_id = c.student_id and b.subject_name = c.subject_name
group by a.student_id, b.subject_name;

// https://www.w3schools.com/sql/sql_join_left.asp
The LEFT JOIN keyword returns all records from the left table (table1), 
and the matched records from the right table (table2). 
The result is NULL from the right side, if there is no match.