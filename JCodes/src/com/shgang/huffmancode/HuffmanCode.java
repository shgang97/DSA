package com.shgang.huffmancode;

import java.io.*;
import java.util.*;

public class HuffmanCode {
	public static void main(String[] args) {
//		String content = "i like like like java do you like a java";
//		byte[] contentBytes = content.getBytes();
//		System.out.println(contentBytes.length);//40
//		List<Node> nodes = getNodes(contentBytes);
//		System.out.println(nodes);
//		Node huffmanTree = createHuffmanTree(nodes);
////		huffmanTree.preOrderErgodic();
//		preOrderErgodic(huffmanTree);
//		Map<Byte, String> huffmancodes = getCodes(huffmanTree);
//		System.out.println(huffmanCodes);
//		byte[] huffmanCodeBytes = zip(contentBytes, huffmancodes);
//		byte[] huffmanCodeBytes = huffmanZip(contentBytes);
//		System.out.println(Arrays.toString(huffmanCodeBytes));
//
//		byte[] decodeBytes = decode(huffmanCodes, huffmanCodeBytes);
//		System.out.println(new String(decodeBytes));
		String zipSrcFile = "/Users/sangel/DSA/JCodes/src/com/shgang/huffmancode/java.jpeg";
		String zipDstFile = "/Users/sangel/DSA/JCodes/src/com/shgang/huffmancode/java.zip";
		String unzipDstFile = "/Users/sangel/DSA/JCodes/src/com/shgang/huffmancode/java2.jpeg";
//		zipFile(zipSrcFile, zipDstFile);
		unZipFile(zipDstFile,unzipDstFile);

	}

	public static void unZipFile(String zipFile, String dstFile) {
		InputStream is = null;
		ObjectInputStream ois = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(zipFile);
			ois = new ObjectInputStream(is);
			byte[] huffmanBytes = (byte[]) ois.readObject();
			Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();
			byte[] bytes = decode(huffmanCodes, huffmanBytes);
			System.out.println("*");
			os = new FileOutputStream(dstFile);
			os.write(bytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				os.close();
				ois.close();
				is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void zipFile(String srcFile, String dstFile) {
		FileInputStream is = null;
		OutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			is = new FileInputStream(srcFile);
			byte[] b = new byte[is.available()];
			is.read(b);
			byte[] huffmanBytes = huffmanZip(b);
			os = new FileOutputStream(dstFile);
			oos = new ObjectOutputStream(os);
			oos.writeObject(huffmanBytes);
			oos.writeObject(huffmanCodes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				is.close();
				oos.close();
				os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
		StringBuilder stringBuilder = new StringBuilder();
		boolean flag;
		byte b;
		for (int i = 0; i < huffmanBytes.length; i++) {
			flag = (i == huffmanBytes.length - 1);
			b = huffmanBytes[i];
			stringBuilder.append(byteToBitString(!flag, b));
		}
//		System.out.println(stringBuilder.toString());
		Map<String, Byte> map = new HashMap<>();
		for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		List<Byte> list = new ArrayList<>();
		int count;
		for (int i = 0; i < stringBuilder.length(); ) {
			count = 1;
			flag = true;
			Byte value = null;
			while (flag) {
				String key = stringBuilder.substring(i, i + count);
				value = map.get(key);
				if (value == null) {
					count++;
				} else {
					flag = false;
				}
			}
			list.add(value);
			i += count;

		}
		byte decodeBytes[] = new byte[list.size()];
		for (int i = 0; i < decodeBytes.length; i++) {
			decodeBytes[i] = list.get(i);
		}
		return decodeBytes;
	}

	private static String byteToBitString(boolean flag, byte b) {
		int temp = b;
		if (flag) {
			temp |= 256;
		}
		String str = Integer.toBinaryString(temp);
		if (flag) {
			return str.substring(str.length() - 8);
		} else {
			return str;
		}

	}

	private static byte[] huffmanZip(byte[] bytes) {
		List<Node> nodes = getNodes(bytes);
		Node huffmanTree = createHuffmanTree(nodes);
		Map<Byte, String> huffmanCodes = getCodes(huffmanTree);
		byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
		return huffmanCodeBytes;
	}

	static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
	static StringBuilder stringBuilder = new StringBuilder();

	private static Map<Byte, String> getCodes(Node root) {
		if (root == null) {
			return null;
		}
		//处理root的左子树
		getCodes(root.left, "0", stringBuilder);
		//处理root的右子树
		getCodes(root.right, "1", stringBuilder);
		return huffmanCodes;
	}

	private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
		StringBuilder stringBuilder = new StringBuilder();
		for (byte b : bytes) {
			stringBuilder.append(huffmanCodes.get(b));
		}
		int len;//int len=(stringBuilder.length()+7)/8
		if (stringBuilder.length() % 8 == 0) {
			len = stringBuilder.length() / 8;
		} else {
			len = stringBuilder.length() / 8 + 1;
		}
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;
		for (int i = 0; i < stringBuilder.length(); i += 8) {
			String strByte;
			if (i + 8 > stringBuilder.length()) {
				strByte = stringBuilder.substring(i);
			} else {
				strByte = stringBuilder.substring(i, i + 8);
			}
			huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
			index++;
		}
		return huffmanCodeBytes;
	}

	private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if (node != null) {
			if (node.data == null) {
				getCodes(node.left, "0", stringBuilder2);
				getCodes(node.right, "1", stringBuilder2);
			} else {
				huffmanCodes.put(node.data, stringBuilder2.toString());
			}
		}
	}

	private static List<Node> getNodes(byte[] bytes) {
		ArrayList<Node> nodes = new ArrayList<>();
		HashMap<Byte, Integer> counts = new HashMap<>();
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			} else {
				counts.put(b, count + 1);
			}
		}
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}

	private static Node createHuffmanTree(List<Node> nodes) {
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);

			Node parent = new Node(null, leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;

			nodes.remove(leftNode);
			nodes.remove(rightNode);

			nodes.add(parent);
//			System.out.println(nodes);
		}
		return nodes.get(0);
	}

	public static void preOrderErgodic(Node root) {
		if (root != null) {
			root.preOrderErgodic();
		} else {
			System.out.println("是空树，不能遍历～～");
		}
	}


}

class Node implements Comparable<Node> {
	Byte data;
	int weight;
	Node left;
	Node right;

	public Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Node{" +
				"data=" + data +
				", weight=" + weight +
				'}';
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}

	public void preOrderErgodic() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrderErgodic();
		}
		if (this.right != null) {
			this.right.preOrderErgodic();
		}
	}
}
