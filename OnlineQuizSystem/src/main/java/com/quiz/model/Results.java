package com.quiz.model;

public class Results {
	private int id;
	private String studentName;
	private int score;

	public Results() {
	}

	public Results(String studentName, int score) {
		this.studentName = studentName;
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Results{" + "id=" + id + ", studentName='" + studentName + '\'' + ", score=" + score + '}';
	}
}
