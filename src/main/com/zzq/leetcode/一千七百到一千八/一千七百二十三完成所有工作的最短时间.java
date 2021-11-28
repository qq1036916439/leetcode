package com.zzq.leetcode.一千七百到一千八;

/**
 * @author zhangzhiqiang
 * @date 2021-05-08 1:15 下午
 */
public class 一千七百二十三完成所有工作的最短时间 {

	int[] jobs;
	int n, k;
	int ans = Integer.MAX_VALUE;

	public int minimumTimeRequired(int[] _jobs, int _k) {
		jobs = _jobs;
		n = jobs.length;
		k = _k;
		int[] sum = new int[k];
		dfs(0, 0, sum, 0);
		return ans;
	}

	/**
	 * 【补充说明】不理解可以看看下面的「我猜你问」的 Q5 哦 ~
	 * <p>
	 * u     : 当前处理到那个 job
	 * used  : 当前分配给了多少个工人了
	 * sum   : 工人的分配情况          例如：sum[0] = x 代表 0 号工人工作量为 x
	 * max   : 当前的「最大工作时间」
	 */
	void dfs(int u, int used, int[] sum, int max) {
		if (max >= ans) {
			return;
		}
		if (u == n) {
			ans = max;
			return;
		}
		// 优先分配给「空闲工人」
		if (used < k) {
			sum[used] = jobs[u];
			dfs(u + 1, used + 1, sum, Math.max(sum[used], max));
			sum[used] = 0;
		}
		for (int i = 0; i < used; i++) {
			sum[i] += jobs[u];
			dfs(u + 1, used, sum, Math.max(sum[i], max));
			sum[i] -= jobs[u];
		}
	}


}
