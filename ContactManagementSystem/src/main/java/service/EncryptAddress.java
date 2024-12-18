package service;

public class EncryptAddress {
	public boolean isHexadecimal(String input) {
	    if (input == null || input.isEmpty()) {
	        return false;
	    }
	    else if (input.length() % 2 != 0) {
	        return false;
	    }
	    return input.matches("^[0-9a-fA-F]+$");
	}

	public String encrypt(String input) {
	    if (input == null || input.isEmpty()) {
	        return "";
	    }

	    StringBuilder hexString = new StringBuilder();
	    for (char c : input.toCharArray()) {
	        hexString.append(String.format("%02x", (int) c));
	    }

	    return hexString.toString();
	}
	
	public String decrypt(String hexInput) {
	    if (hexInput == null || hexInput.isEmpty() || hexInput.length() % 2 != 0) {
	        throw new IllegalArgumentException("Invalid hexadecimal input");
	    }

	    StringBuilder output = new StringBuilder();
	    for (int i = 0; i < hexInput.length(); i += 2) {
	        String hexPair = hexInput.substring(i, i + 2);
	        int charCode = Integer.parseInt(hexPair, 16);
	        output.append((char) charCode);
	    }

	    return output.toString();
	}
}
