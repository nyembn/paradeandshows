It is a demonstration of thread synchronization in Java. It follows a story as the following.
Students from two different schools will participate in a Halloween Parade.
The students from one school wear blue costumes, and the other students wear
orange costumes. Students arrive at the meeting place (simulated by
sleep( random )) in front of the stadium and group in formations of two orange
and one blue costume. Once a group is formed (students of the same group will
wait on the same notification object), it will start parading around the stadium
(sleep( random )) . Only students in groups may march in the parade. The very
last group can start marching even it is incomplete. After each circle around the
stadium, students separate from their groups and take a snack break (simulated
by sleep( random )) . Next, they will gather in front of the auditorium entrance for a
circus show.

A new circus show session starts every 1 hour and 30 minutes. If a show
is already in session, students will wait (each student should block on its own
notification object – similar to rwcv.java). When the previous show session ends,
the students leave the auditorium. Students that are waiting to see the coming
show then enter the room in a FCFS order (implement a platoon policy) and take
one of the available seats. If there are no free seats, students, will attempt to see
the next show. When the show is about to start, no student can enter and disturb
it.
There will be a total of three shows and students are anxious to see all of
them. However, throughout the entire day there will be a total of six parades
(one stadium circle) one hour apart, and students must participate in at least
three parades; they must alternate between the parade participations and the
circus shows. Depending on how long they take to circle the stadium, how long
the snack breaks take, and the availability of seats in the auditorium, not all
students will have the chance to see all three shows.

Parades and show times
Parades: 11:00AM, 12:00PM, 1:00PM, 2:00PM, 3:00PM, 4:00PM, 5:00PM
Show times: 11:45AM, 1:15PM, 2:45PM
Students will terminate after the last parade ends or if they already managed to
participate in three parades and watched 3 shows. Before terminating students
will print a review with the following information:
Student (thread) name, what parade he participated in by giving its starting time,
what shows he/she watched by giving its starting time.
