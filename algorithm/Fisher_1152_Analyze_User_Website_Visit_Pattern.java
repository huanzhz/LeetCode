
//https://www.youtube.com/watch?v=V510Lbtrm5s
//LeetCode 1152. Analyze User Website Visit Pattern - Interview Prep Ep 109
//https://leetcode.com/problems/analyze-user-website-visit-pattern/

public static class Solution1 {
        public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
			// username, timestamp, pagename
            Map<String, TreeMap<Integer, String>> userToSiteMap = new HashMap<>();
            for (int i = 0; i < username.length; i++) {
                if (!userToSiteMap.containsKey(username[i])) {
                    userToSiteMap.put(username[i], new TreeMap<>());
                }
				// get the treemap<timestamp,pagename> of the key-username
                TreeMap<Integer, String> timeToSiteMap = userToSiteMap.get(username[i]);
                timeToSiteMap.put(timestamp[i], website[i]);
                userToSiteMap.put(username[i], timeToSiteMap);
            }
			
            Map<String, Integer> sequenceCountMap = new HashMap<>();
			// https://www.geeksforgeeks.org/hashmap-keyset-method-in-java/
			// keySet -> get the username 
            for (String user : userToSiteMap.keySet()) {
				// get the treemap<timestamp,pagename> 
                TreeMap<Integer, String> timeToSiteMap = userToSiteMap.get(user);
				// maximum 3 site
                if (timeToSiteMap.size() < 3) {
                    continue;
                } else {
                    List<Integer> times = new ArrayList<>();
					// get timestamp
                    for (int time : timeToSiteMap.keySet()) {
                        times.add(time);
                    }
                    List<String> allSequences = formAllSequences(times, timeToSiteMap);
					// check the path only once
                    Set<String> encounteredSequence = new HashSet<>();
                    for (String sequence : allSequences) {
                        if (encounteredSequence.add(sequence)) {
                            sequenceCountMap.put(sequence, sequenceCountMap.getOrDefault(sequence, 0) + 1);
                        }
                    }
                }
            }
            List<String> mostVisitedPattern = new ArrayList<>();
            int count = 0;
            String result = null;
			// find out the most viewed path
            for (String sequence : sequenceCountMap.keySet()) {
                if (sequenceCountMap.get(sequence) > count) {
                    result = sequence;
                    count = sequenceCountMap.get(sequence);
                } else if (count == sequenceCountMap.get(sequence)) {
					// if there is 2 similar solution
                    if (sequence.compareTo(result) < 0) {
                        result = sequence;
                    }
                }
            }
			// split them up 
            for (String site : result.split("->")) {
                mostVisitedPattern.add(site);
            }
            return mostVisitedPattern;
        }

        private List<String> formAllSequences(List<Integer> times, TreeMap<Integer, String> timeToSiteMap) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < times.size() - 2; i++) {
                for (int j = i + 1; j < times.size() - 1; j++) {
                    for (int k = j + 1; k < times.size(); k++) {
                        result.add(timeToSiteMap.get(times.get(i)) + "->" + timeToSiteMap.get(times.get(j)) + "->" + timeToSiteMap.get(times.get(k)));
                    }
                }
            }
            return result;
        }
    }






