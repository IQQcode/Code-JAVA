package iqqcode.algorithm.array;


/**
 * @Author: Mr.Q
 * @Date: 2020-05-14 11:43
 * @Description:����ʵ�ַ��ű�
 * �ο����ӣ�https://www.jianshu.com/p/ad86f65f081d
 */
public class SymbolTableArray<Key extends Comparable<Key>,Value> {
    private Key[] keys; //������
    private Value[] values; //ֵ����
    private int N; //��¼���ű���Ԫ�ظ���

    public SymbolTableArray(int len) {
        this.keys = (Key[]) new Comparable[len];
        this.values = (Value[]) new Object[len];
        N = 0;
    }

    /**
     * ��¼���ű��м�ֵ�Եĸ���
     * @return
     */
    public int size() {
        return this.N;
    }

    //���ű��в����ֵ��
    public void put(Key key, Value value) {
        //���ݼ��ҵ��ü�λ�ڼ������е�����λ��
        int target = rank(key);
        //����Ѿ������˼����͸���
        if (target < N && keys[target].compareTo(key) == 0) {
           values[target] = value;
           return;
        }
        // �����ڣ��Ƚ������ڳ��ռ䣬Ȼ�����
        for (int i = N; i > target; i++) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[target] = key;
        values[target] = value;
        N++;
    }

    //ɾ�����ű��м�Ϊkey�ļ�ֵ��
    public void delete(Key key) {
        //���ݼ��ҵ��ü�λ�ڼ������е�����λ��
        int target = rank(key);
        if (target == N || keys[target].compareTo(key) != 0) {
            return;
        }
        for (int i = target; i < N - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        keys[N] = null;
        values[N] = null;
        N--;
    }

    /**
     * ��ȡ��Ϊkey��valueֵ
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (N == 0) {
            return null;
        }
        //���ݼ��ҵ��ü�λ�ڼ������е�����λ��
        int target = rank(key);
        if (target < N && keys[target].compareTo(key) == 0) {
            return values[target];
        }
        return null;
    }

    /**
     * ����key�ҳ�value(��������[key]���ж��ֲ���)
     * @param key
     * @return
     */
    public int rank(Key key) {
        int low = 0;
        int high = N - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int temp = key.compareTo(keys[mid]);
            if (temp == 0) {
                return mid;
            }else if (temp < 0) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}
