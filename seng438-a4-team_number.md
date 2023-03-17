**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      |     |
| -------------- | --- |
| Student Names: |     |
|                |     |
|                |     |
|                |     |

# Introduction

# Analysis of 10 Mutants of the Range class

#1.  
Function: public boolean contains(double value)  
Line: 144  
Mutation: Changed conditional boundary  
This mutant changes “value >= this.lower” to “value > this.lower”. This mutant survives because our only test for contains checks that 10 is within the range (5, 20). Since 10 is both greater-than and greater-than-or-equal-to 5, the test passes. We don’t have a test on the lower boundary, so we cannot identify this mutant.

#2  
Function: public boolean contains(double value)  
Line: 144  
Mutation: Negated conditional  
This mutant changes “value >= this.lower” to “value < this.lower”. This mutant is killed, because 10 is not less than 5. The entire return statement evaluates to false, which causes our test to fail. This therefore kills the mutant.

#3  
Function: public double constrain(double value)  
Line: 188  
Mutation: Incremented (a++) double local variable number 1.  
This mutant survives, because it postfix increments value. Since it is a postfix increment, the original value of value is stored in result. We do not have any tests where an increment of 1 crosses the boundary from outside to inside the range, or vice versa. When the constrained value is on the lower bound, the lower bound value is saved in “result”. Then “value” gets incremented, and after a failed conditional, “result” gets immediately returned, but it already contained the value we expected. Similarly, when the constrained value is in the middle, “result” gets the expected output, the conditional on line 189 is not triggered, and then “result” is returned. But, again, “result” contains the expected value. Similar logic can be applied to the rest of the test cases.

#4  
Function: public boolean constrain(double value)  
Line: 188  
Mutation: Incremented (++a) double local variable number 1.  
This mutant is killed by our test case. We have a range of (-5.7, 9.1). We send in a constrained value of 2.3. This immediately gets incremented to 3.3, and then stored in “result”. So, we have “result” and “value” equal to 3.3 going into line 189. Since 3.3 is still within the range, the conditional block is skipped, and “result” is returned. However, result contains 3.3, which is not what we expect, so the test fails and the mutant is killed.

#5  
Function: public double constrain(double value)  
Line: 188  
Mutation: Negated double variable 1.  
This mutant is killed. That is because, for one of our tests, we have a constrain value that even when negated is still within the range. Thus “result” is returned immediately on line 197. However, it contains -2.3, not 2.3, and so the wrong result is returned. This fails our test case.

#6  
Function: public static Range scale(Range base, double factor)  
Line: 410  
Mutation: Changed conditional boundary.  
This mutation survives. The condition “factor < 0” is mutated to “factor <= 0”. This mutation is not killed, because we do not have a test where the factor is 0. We therefore cannot discriminate between < and <=.

#7  
Function: public static Range scale(Range base, double factor)  
Line: 410  
Mutation: Negated conditional.  
This mutation is killed. The condition “factor < 0” is mutated to “factor >= 0”. Our test passes in a factor of 2, and 2 >= 0, so it throws an IllegalArgumentException, which fails our test. This kills the mutant.

#8  
Function: public boolean intersects(double b0, double b1)  
Line: 157  
Mutation: Changed conditional boundary.  
This mutation is not killed. The condition “b0 <= this.lower” is mutated to “b0 < this.lower”. This is not killed because we do not have a test where “b0” is the lower boundary of the range. In all of our test cases, b0 < this.lower, so the change to the source code is not caught. If we had a test case where b0 == this.lower and b1 >= this.upper, we would have killed the mutant.

#9  
Function: public boolean intersects(double b0, double b1)  
Line: 157  
Mutation: Negated conditional.  
This mutation is killed. The condition “b0 <= this.lower” is mutated to “b0 > this.lower”. One of our tests has the range of (-10.5, 10.5), b0 = 10.7, and b1 = 13.8. When line 157 is evaluated, the condition is satisfied. Then, on line 158, the function returns true. However, we expect the function to return false, because the ranges do not intersect. Thus the mutant is killed.

#10  
Function: public static Range shift(Range base, double delta, boolean allowZeroCrossing)  
Line: 367  
Mutation: Replaced double addition with multiplication.  
This mutant is killed. The relevant test here has a range of (2, 6). With the mutation, a new Range is constructed whose lower bound is 2 \* 158 = 316, and its upper bound is 164. This throws an exception from the constructor and thus fails the test and kills the mutant.

#11  
Function: public static Range shift(Range base, double delta, boolean allowZeroCrossing)  
Line: 367  
Mutation: Replaced double addition with division.  
This mutant survives. This is because in our tests for this version of the overloaded function, we only check the upper bound. Since this mutation only affects the lower bound of the returned range, and does so in a way that does not cause an exception during construction, we do not catch that the lower bound of the range is incorrect.

#12  
Function: public double getCentralValue()  
Line: 132  
Mutation: Incremented (a++) double field lower.  
This mutant is not killed. This is because the postfix increment of the lower variable occurs in the line that returns a double from the function. The current value of the variable will be used, and then it will be incremented. Thus, the line executes using the current value of this.lower, and so the answer is calculated using the correct value, and so our test detects no difference.

#13  
Function: public double getCentralValue()  
Line: 132  
Mutation: Incremented (++a) double field lower.  
This mutant is killed. This is because the prefix increment takes the current value of this.lower, increments it by one, and then does the calculation in line 132. This results in a different value than the test anticipates, which causes our test case to fail and therefore kill the mutant.

# Report all the statistics and the mutation score for each test class

# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed

# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
