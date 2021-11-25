package com.realcoderz.model;

import java.util.List;
import java.util.stream.Collector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OBJECTIVEQUESTION")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String question;
	private String op1;
	private String op2;
	private String op3;
	private String op4;	
	 
	private int ans_option;
	
	private int choose;
	
	public Question() {
		
	}
	
	public Question(int id, String question, String op1, String op2, String op3, String op4, int ans_option,
			int choose) {
		super();
		this.id = id;
		this.question = question;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.ans_option = ans_option;
		this.choose = choose;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getOp3() {
		return op3;
	}

	public void setOp3(String op3) {
		this.op3 = op3;
	}

	public String getOp4() {
		return op4;
	}

	public void setOp4(String op4) {
		this.op4 = op4;
	}

	public int getAns_option() {
		return ans_option;
	}

	public void setAns_option(int i) {
		this.ans_option = i;
	}

	public int getChoose() {
		return choose;
	}

	public void setChoose(int choose) {
		this.choose = choose;
	}

	public Object collect(Collector<Object, ?, List<Object>> list) {
		return null;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", op1=" + op1 + ", op2=" + op2 + ", op3=" + op3
				+ ", op4=" + op4 + ", ans_option=" + ans_option + ",choose=" + choose + "]";
	}
	

}
