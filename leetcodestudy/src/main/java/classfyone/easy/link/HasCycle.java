package classfyone.easy.link;

/**
 * 题目：环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 注意：双指针法，一个步长为1，一个步长为2。 如果是环则一定指针一定会相遇。
 *
 *
 */
public class HasCycle {
    public static Boolean hasCycle(ListNode head){
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        //这里必须do-while
        do {
            //这里必须都用fast判断next和next.next
            if(fast.next==null || fast.next.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }while (slow != fast);
        //跳出循环就说明是环形链表
        return true;
    }

    //错误写法，while条件就判断错了
//        while (oneStep.next!=null && twoStep.next.next!=null ){
//            oneStep = oneStep.next;
//            twoStep = twoStep.next.next;
//            if(oneStep == twoStep){
//                return true;
//            }
//        }

    public static void main(String[] args) {



    }
}
