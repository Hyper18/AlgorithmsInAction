package Week23;

import java.util.*;

/**
 * @author Hyperspace
 * @date 2024/12/16
 * @file Q136_获取连通的相邻节点列表.java
 * <p>
 * 题目描述
 * 在网元内，存在了 N 个转发节点，
 * 每个转发节点有自己唯一的标识 TB 且每个节点有 M 个端口，节点间通过端口进行报文通讯。
 * 出于业务隔离的需求，服务器内的端口被划分为多个通讯平面
 * (用 VLAN 隔离，每个 VLAN 都有一个 VLAN ID作为标识)
 * 1、如果两个端口的VLAN ID相同，则说明这两个端口处于同个 VLAN，且处于连通状态;
 * 2、如果两个端口的VLAN ID不同，则说明这两个端口处于不同 VLAN，彼此不连通;
 * 现给出节点 A 的端口数及其各端口所属的 VLAN ID，以及节点 A 相邻的其他节点和端口信息。
 * 要求获取与节点 A 处于连通状态的所有相邻节点的 TB 列表（按 TB 从小到大顺序输出）
 * <p>
 * 输入描述
 * 第 1 行: M VLAN_ID_1...VLAN_ID_m 数据间有空格隔开，分别表示:
 * 节点 A 有 M 个端口，各个端口所属的 VLAN_ID，即后面 VLAN_ID_m 表示第 m 个端口的 VLAN ID。
 * 其中，网元内节点的端口数量 M 的取值范围为[1,4];
 * 端口划分 VLAN ID 的取值范围为[1,4];
 * 第 2 行: N 表示与节点 A 相邻的其他节点有 N 个，N 的取值范围为[0,4000)
 * 第 3 行开始，将有 N 行数据，分别描述与节点 A 相邻的节点的 TB 和端口信息
 * 输入格式为: TBx Mx VLAN_ID_xx...VLAN_ID_xm 数据间有空格隔开，
 * 分别表示:
 * 节点 x 的 TBx，有 Mx 个端口，
 * 各个端口所属的 VLAN_ID，即后面 VLAN_ID_xm 表示第 m 个端口的 VLAN ID。
 * 其中，网元内节点 TB 的取值范围为(0,4294967295);
 * <p>
 * 输出描述
 * 第 1 行: N
 * 表示与节点 A 连通的相邻节点个数，如 N 为 0，则无需在输出其他信息
 * 第 2 行: TB_1...TB_n
 * 数据间有空格隔开，分别表示：与节点 A 连通的相邻节点的 TB，个数为 N，按从小到大的顺序输出。
 * <p>
 * 提示信息
 * 节点 A 有 1 个端口，VLAN ID 为 1。
 * 相邻的 3 个节点中：
 * 节点 1024 有 2 个端口，其中一个端口的 VLAN ID 为 1，与节点 A 连通。
 * 节点 1023 有 1 个端口，VLAN ID 为 1，与节点 A 连通。
 * 节点 1025 的端口 VLAN ID 分别为 2, 2, 3，没有与节点 A 相同的 VLAN ID，不连通。
 * 最终输出连通的 2 个相邻节点 1023 和 1024，按 TB 从小到大排序。
 * <p>
 * 思路
 * hash
 * 题干很长，本质还是模拟
 */
public class Q136_获取连通的相邻节点列表 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < m; i++) {
            st.add(sc.nextInt());
        }
        int n = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        while (n-- > 0) {
            int id = sc.nextInt(), t = sc.nextInt();
            int[] ports = new int[t];
            for (int i = 0; i < t; i++) {
                ports[i] = sc.nextInt();
            }
            for (int i = 0; i < t; i++) {
                if (st.contains(ports[i])) {
                    res.add(id);
                    break;
                }
            }
        }
        Collections.sort(res);
        int len = res.size();
        System.out.println(len);
        if (len > 0) {
            for (int i = 0; i < len - 1; i++) {
                System.out.print(res.get(i) + " ");
            }
            System.out.println(res.get(len - 1));
        }
    }
}
