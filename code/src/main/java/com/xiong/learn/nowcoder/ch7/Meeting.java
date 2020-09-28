package com.xiong.learn.nowcoder.ch7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 会议安排问题
 */
public class Meeting {
    public static class MeetingItem {
        public int start;
        public int end;

        public MeetingItem(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static List<MeetingItem> average(MeetingItem[] meetingItems) {
        PriorityQueue<MeetingItem> priorityQueue = new PriorityQueue<>(new Comparator<MeetingItem>() {
            @Override
            public int compare(MeetingItem o1, MeetingItem o2) {
                return o1.end - o2.end;
            }
        });

        for (int i = 0; i < meetingItems.length; i++) {
            priorityQueue.add(meetingItems[i]);
        }
        int lastEnd = 0;

        List<MeetingItem> res = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            MeetingItem m = priorityQueue.poll();
            if (m.start >= lastEnd) {
                res.add(m);
                lastEnd = m.end;
            }
        }
        return res;
    }
}
