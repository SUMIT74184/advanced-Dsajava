package DynamicProgramming;

public class Scs {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int [][]dp=longestCommonSubsequence1(str1, str2);
        int i = m, j = n;
        StringBuilder result = new StringBuilder();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                // If the characters are the same, add it once
                result.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // If coming from top has higher value, take character from str1
                result.append(str1.charAt(i - 1));
                i--;
            } else {
                // Otherwise, take character from str2
                result.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters from str1 (if any)
        while (i > 0) {
            result.append(str1.charAt(i - 1));
            i--;
        }

        // Add remaining characters from str2 (if any)
        while (j > 0) {
            result.append(str2.charAt(j - 1));
            j--;
        }

        // Reverse the result to get the final supersequence
        return result.reverse().toString();
    }


    public int[][] longestCommonSubsequence1(String t1, String t2) {
        int n=t1.length();
        int m=t2.length();
        int [][]dp=new int[n+1][m+1];

        dp[0][0]=0;


        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(t1.charAt(i-1)==t2.charAt(j-1)){ //shifting logic
                    dp[i][j]=1+dp[i-1][j-1];

                }else{
                    int case1=dp[i-1][j];
                    int case2=dp[i][j-1];
                    dp[i][j]= Math.max(case1,case2);

                }
            }
        }
        print(dp);
        return dp;
    }

    public void print(int [][]dp){
        int n= dp.length;
        int m=dp[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.println(dp[i][j]+" ,");
            }
            System.out.println();
        }
    }
}
//import React, { useState, useEffect } from 'react';
//        import { Play, Pause, RotateCcw, SkipForward } from 'lucide-react';
//
//        const LCSSCSVisualizer = () => {
//        const [str1, setStr1] = useState("AGGTAB");
//  const [str2, setStr2] = useState("GXTXAYB");
//  const [step, setStep] = useState(0);
//  const [isPlaying, setIsPlaying] = useState(false);
//  const [phase, setPhase] = useState('lcs'); // 'lcs' or 'scs'
//  const [lcsTable, setLcsTable] = useState([]);
//  const [scsPath, setScsPath] = useState([]);
//  const [scsResult, setScsResult] = useState("");
//
//  const buildLCSTable = (s1, s2) => {
//        const n = s1.length;
//    const m = s2.length;
//    const dp = Array(n + 1).fill(0).map(() => Array(m + 1).fill(0));
//
//        for (let i = 1; i <= n; i++) {
//        for (let j = 1; j <= m; j++) {
//        if (s1[i - 1] === s2[j - 1]) {
//dp[i][j] = 1 + dp[i - 1][j - 1];
//        } else {
//dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//        }
//                }
//                }
//                return dp;
//  };
//
//          const buildSCSPath = (s1, s2, dp) => {
//        const path = [];
//let i = s1.length;
//let j = s2.length;
//let result = [];
//
//        while (i > 0 && j > 0) {
//        path.push({ i, j, action: 'checking' });
//        if (s1[i - 1] === s2[j - 1]) {
//        result.unshift(s1[i - 1]);
//        path.push({ i, j, action: 'match', char: s1[i - 1] });
//i--;
//j--;
//        } else if (dp[i - 1][j] > dp[i][j - 1]) {
//        result.unshift(s1[i - 1]);
//        path.push({ i, j, action: 'from_str1', char: s1[i - 1] });
//i--;
//        } else {
//        result.unshift(s2[j - 1]);
//        path.push({ i, j, action: 'from_str2', char: s2[j - 1] });
//j--;
//        }
//        }
//
//        while (i > 0) {
//        result.unshift(s1[i - 1]);
//      path.push({ i, j, action: 'remaining_str1', char: s1[i - 1] });
//i--;
//        }
//
//        while (j > 0) {
//        result.unshift(s2[j - 1]);
//      path.push({ i, j, action: 'remaining_str2', char: s2[j - 1] });
//j--;
//        }
//
//        return { path, result: result.join('') };
//        };
//
//useEffect(() => {
//        const table = buildLCSTable(str1, str2);
//setLcsTable(table);
//    const { path, result } = buildSCSPath(str1, str2, table);
//setScsPath(path);
//setScsResult(result);
//  }, [str1, str2]);
//
//useEffect(() => {
//        if (isPlaying) {
//        const maxSteps = phase === 'lcs'
//        ? (str1.length + 1) * (str2.length + 1)
//        : scsPath.length;
//
//      if (step < maxSteps - 1) {
//        const timer = setTimeout(() => setStep(step + 1), 500);
//        return () => clearTimeout(timer);
//      } else {
//setIsPlaying(false);
//      }
//              }
//              }, [isPlaying, step, phase, str1.length, str2.length, scsPath.length]);
//
//        const reset = () => {
//setStep(0);
//setIsPlaying(false);
//setPhase('lcs');
//  };
//
//          const switchPhase = () => {
//setPhase(phase === 'lcs' ? 'scs' : 'lcs');
//setStep(0);
//setIsPlaying(false);
//  };
//
//          const getCurrentLCSStep = () => {
//        const n = str1.length + 1;
//        const m = str2.length + 1;
//        return Math.min(step, n * m - 1);
//  };
//
//          const isCellFilled = (i, j) => {
//        const currentStep = getCurrentLCSStep();
//    const cellIndex = i * (str2.length + 1) + j;
//    return cellIndex <= currentStep;
//  };
//
//          const isCurrentCell = (i, j) => {
//        const currentStep = getCurrentLCSStep();
//    const cellIndex = i * (str2.length + 1) + j;
//    return cellIndex === currentStep;
//  };
//
//          const getSCSCellHighlight = (i, j) => {
//        if (phase !== 'scs' || step >= scsPath.length) return '';
//        const current = scsPath[step];
//        if (current.i === i && current.j === j) return 'bg-yellow-300';
//        return '';
//        };
//
//        return (
//    <div className="p-6 max-w-6xl mx-auto bg-gradient-to-br from-blue-50 to-purple-50 min-h-screen">
//      <div className="bg-white rounded-lg shadow-xl p-6 mb-6">
//        <h1 className="text-3xl font-bold mb-4 text-center text-purple-700">
//LCS & SCS Dynamic Programming Visualizer
//        </h1>
//
//        <div className="grid grid-cols-2 gap-4 mb-6">
//          <div>
//            <label className="block text-sm font-medium mb-2">String 1:</label>
//            <input
//type="text"
//value={str1}
//onChange={(e) => { setStr1(e.target.value.toUpperCase()); reset(); }}
//className="w-full px-3 py-2 border rounded-lg"
//        />
//          </div>
//          <div>
//            <label className="block text-sm font-medium mb-2">String 2:</label>
//            <input
//type="text"
//value={str2}
//onChange={(e) => { setStr2(e.target.value.toUpperCase()); reset(); }}
//className="w-full px-3 py-2 border rounded-lg"
//        />
//          </div>
//        </div>
//
//        <div className="flex gap-3 justify-center mb-6">
//          <button
//onClick={() => setIsPlaying(!isPlaying)}
//className="flex items-center gap-2 px-4 py-2 bg-purple-600 text-white rounded-lg hover:bg-purple-700"
//        >
//        {isPlaying ? <Pause size={20} /> : <Play size={20} />}
//        {isPlaying ? 'Pause' : 'Play'}
//          </button>
//          <button
//onClick={reset}
//className="flex items-center gap-2 px-4 py-2 bg-gray-600 text-white rounded-lg hover:bg-gray-700"
//        >
//            <RotateCcw size={20} />
//Reset
//        </button>
//          <button
//onClick={switchPhase}
//className="flex items-center gap-2 px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700"
//        >
//            <SkipForward size={20} />
//        {phase === 'lcs' ? 'Show SCS' : 'Show LCS'}
//          </button>
//        </div>
//
//        <div className="bg-purple-100 p-4 rounded-lg mb-6">
//          <h2 className="text-xl font-bold mb-2">
//        {phase === 'lcs' ? 'Phase 1: Building LCS Table' : 'Phase 2: Constructing SCS'}
//          </h2>
//          <p className="text-sm">
//        {phase === 'lcs'
//        ? 'Fill the DP table to find the longest common subsequence length.'
//        : 'Trace back through the LCS table to build the shortest common supersequence.'}
//          </p>
//        </div>
//
//        {phase === 'lcs' ? (
//          <div className="overflow-x-auto">
//            <table className="mx-auto border-collapse">
//              <thead>
//                <tr>
//                  <th className="border-2 border-gray-400 p-2 bg-gray-200"></th>
//                  <th className="border-2 border-gray-400 p-2 bg-gray-200">∅</th>
//        {str2.split('').map((char, idx) => (
//                    <th key={idx} className="border-2 border-gray-400 p-2 bg-gray-200 font-mono">
//        {char}
//                    </th>
//        ))}
//                </tr>
//              </thead>
//<tbody>
//{lcsTable.map((row, i) => (
//        <tr key={i}>
//        <th className="border-2 border-gray-400 p-2 bg-gray-200 font-mono">
//        {i === 0 ? '∅' : str1[i - 1]}
//        </th>
//        {row.map((cell, j) => (
//                <td
//                key={j}
//                className={`border-2 border-gray-400 p-3 text-center font-mono text-lg ${
//    isCurrentCell(i, j) ? 'bg-green-400 animate-pulse' :
//            isCellFilled(i, j) ? 'bg-green-200' : 'bg-gray-100'
//} ${getSCSCellHighlight(i, j)}`}
//                      >
//    {isCellFilled(i, j) ? cell : ''}
//                      </td>
//                    ))}
//                  </tr>
//                ))}
//              </tbody>
//            </table>
//          </div>
//        ) : (
//          <div>
//            <div className="overflow-x-auto mb-6">
//              <table className="mx-auto border-collapse">
//                <thead>
//                  <tr>
//                    <th className="border-2 border-gray-400 p-2 bg-gray-200"></th>
//                    <th className="border-2 border-gray-400 p-2 bg-gray-200">∅</th>
//        {str2.split('').map((char, idx) => (
//                      <th key={idx} className="border-2 border-gray-400 p-2 bg-gray-200 font-mono">
//        {char}
//                      </th>
//        ))}
//                  </tr>
//                </thead>
//<tbody>
//{lcsTable.map((row, i) => (
//        <tr key={i}>
//        <th className="border-2 border-gray-400 p-2 bg-gray-200 font-mono">
//        {i === 0 ? '∅' : str1[i - 1]}
//        </th>
//        {row.map((cell, j) => (
//                <td
//                key={j}
//                className={`border-2 border-gray-400 p-3 text-center font-mono text-lg ${
//    getSCSCellHighlight(i, j) || 'bg-green-100'
//}`}
//                        >
//    {cell}
//                        </td>
//                      ))}
//                    </tr>
//                  ))}
//                </tbody>
//              </table>
//            </div>
//
//        {step < scsPath.length && (
//              <div className="bg-yellow-100 p-4 rounded-lg mb-4">
//                <p className="font-bold mb-2">Current Step:</p>
//                <p>Position: ({scsPath[step].i}, {scsPath[step].j})</p>
//                <p>Action: {scsPath[step].action.replace(/_/g, ' ')}</p>
//        {scsPath[step].char && <p>Character added: <span className="font-mono text-lg">{scsPath[step].char}</span></p>}
//              </div>
//        )}
//
//            <div className="bg-blue-100 p-4 rounded-lg">
//              <p className="font-bold mb-2">Shortest Common Supersequence:</p>
//              <p className="text-2xl font-mono text-center">{scsResult}</p>
//              <p className="text-sm text-gray-600 mt-2">Length: {scsResult.length}</p>
//            </div>
//          </div>
//        )}
//
//        <div className="mt-6 p-4 bg-gray-100 rounded-lg">
//          <h3 className="font-bold mb-2">Algorithm Explanation:</h3>
//          <ul className="text-sm space-y-1 list-disc list-inside">
//            <li><strong>LCS Phase:</strong> Build table where dp[i][j] = length of LCS of str1[0..i-1] and str2[0..j-1]</li>
//<li>If characters match: dp[i][j] = 1 + dp[i-1][j-1]</li>
//<li>If they don't match: dp[i][j] = max(dp[i-1][j], dp[i][j-1])</li>
//            <li><strong>SCS Phase:</strong> Trace back from dp[m][n] to construct the supersequence</li>
//<li>Include both strings' characters, but common ones only once</li>
//          </ul>
//        </div>
//      </div>
//    </div>
//        );
//        };
//
//export default LCSSCSVisualizer;