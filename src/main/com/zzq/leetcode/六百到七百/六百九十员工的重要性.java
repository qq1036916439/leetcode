package com.zzq.leetcode.六百到七百;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 六百九十员工的重要性 {
	public int getImportance(List<Employee> employees, int id) {
		HashMap<Integer, Employee> map = new HashMap<>();
		for (int i = 0; i < employees.size(); i++) {
			map.put(employees.get(i).id, employees.get(i));
		}
		int result = 0;
		LinkedList<Integer> list = new LinkedList<>();
		list.add(id);
		while (!list.isEmpty()) {
			Integer currId = list.pollFirst();
			Employee employe = map.get(currId);
			List<Integer> res = employe.subordinates;
			result += employe.importance;
			if (res.size() > 0) {
				for (int i = 0; i < res.size(); i++) {
					list.offer(res.get(i));
				}
			}
		}
		return result;
	}


	HashMap<Integer, Employee> map = new HashMap<>();

	public int getImportance1(List<Employee> employees, int id) {
		for (int i = 0; i < employees.size(); i++) {
			map.put(employees.get(i).id, employees.get(i));
		}

		return dfs(id);
	}

	public int dfs(int id) {
		Employee employee = map.get(id);
		int total = employee.importance;
		List<Integer> subordinates = employee.subordinates;
		for (int subId : subordinates) {
			total += dfs(subId);
		}
		return total;
	}

	class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	}

}
