/*
    Cactus Kev's Poker Hand Evaluator
    http://suffe.cool/poker/evaluator.html
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class HandChecker
{
    private static int[] playerOneHand;
    private static int[] playerTwoHand;
    private static final short[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};
    private static boolean hasAlreadyLoaded = false;

    private static ArrayList<Short> flushes = new ArrayList<>();
    private static ArrayList<Short> unique5 = new ArrayList<>();
    private static ArrayList<Short> hash_values = new ArrayList<>();

    private static final Short hash_adjust[] = {
        0, 5628, 7017, 1298, 2918, 2442, 8070, 6383, 6383, 7425, 2442, 5628, 8044, 7425, 3155, 6383,
        2918, 7452, 1533, 6849, 5586, 7452, 7452, 1533, 2209, 6029, 2794, 3509, 7992, 7733, 7452, 131,
        6029, 4491, 1814, 7452, 6110, 3155, 7077, 6675, 532, 1334, 7555, 5325, 3056, 1403, 1403, 3969,
        4491, 1403, 7592, 522, 8070, 1403, 0, 1905, 3584, 2918, 922, 3304, 6675, 0, 7622, 7017,
        3210, 2139, 1403, 5225, 0, 3969, 7992, 5743, 5499, 5499, 5345, 7452, 522, 305, 3056, 7017,
        7017, 2139, 1338, 3056, 7452, 1403, 6799, 3204, 3290, 4099, 1814, 2191, 4099, 5743, 1570, 1334,
        7363, 1905, 0, 6799, 4400, 1480, 6029, 1905, 0, 7525, 2028, 2794, 131, 7646, 3155, 4986,
        1858, 2442, 7992, 1607, 3584, 4986, 706, 6029, 5345, 7622, 6322, 5196, 1905, 6847, 218, 1785,
        0, 4099, 2981, 6849, 4751, 3950, 7733, 3056, 5499, 4055, 6849, 1533, 131, 5196, 2918, 3879,
        5325, 2794, 6029, 0, 0, 322, 7452, 6178, 2918, 2320, 6675, 3056, 6675, 1533, 6029, 1428,
        2280, 2171, 6788, 7452, 3325, 107, 4262, 311, 5562, 7857, 6110, 2139, 4942, 4600, 1905, 0,
        3083, 5345, 7452, 6675, 0, 6112, 4099, 7017, 1338, 6799, 2918, 1232, 3584, 522, 6029, 5325,
        1403, 6759, 6849, 508, 6675, 2987, 7745, 6870, 896, 7452, 1232, 4400, 12, 2981, 3850, 4491,
        6849, 0, 6675, 747, 4491, 7525, 6675, 7452, 7992, 6921, 7323, 6849, 3056, 1199, 2139, 6029,
        6029, 190, 4351, 7891, 4400, 7134, 1533, 1194, 3950, 6675, 5345, 6383, 7622, 131, 1905, 2883,
        6383, 1533, 5345, 2794, 4303, 1403, 0, 1338, 2794, 992, 4871, 6383, 4099, 2794, 3889, 6184,
        3304, 1905, 6383, 3950, 3056, 522, 1810, 3975, 7622, 7452, 522, 6799, 5866, 7084, 7622, 6528,
        2798, 7452, 1810, 7907, 642, 5345, 1905, 6849, 6675, 7745, 2918, 4751, 3229, 2139, 6029, 5207,
        6601, 2139, 7452, 5890, 1428, 5628, 7622, 2139, 3146, 2400, 578, 941, 7672, 1814, 3210, 1533,
        4491, 12, 2918, 1900, 7425, 2794, 2987, 3465, 1377, 3822, 3969, 3210, 859, 5499, 6878, 1377,
        3056, 4027, 8065, 8065, 5207, 4400, 4303, 3210, 3210, 0, 6675, 357, 5628, 5512, 1905, 3452,
        1403, 7646, 859, 6788, 3210, 2139, 378, 5663, 7733, 870, 0, 4491, 4813, 2110, 578, 2139,
        3056, 4099, 1905, 1298, 4672, 2191, 3950, 5499, 3969, 4974, 6323, 6029, 7414, 6383, 0, 4974,
        3210, 795, 4099, 131, 5345, 5345, 6576, 1810, 1621, 4400, 2918, 1905, 2442, 2679, 6322, 7452,
        2110, 1403, 6383, 2653, 5132, 6856, 7841, 2794, 6110, 2028, 6675, 7425, 6999, 7441, 6029, 183,
        6675, 4400, 859, 1403, 2794, 5985, 5345, 1533, 322, 4400, 1227, 5890, 4474, 4491, 3574, 8166,
        6849, 7086, 5345, 5345, 5459, 3584, 6675, 3969, 7579, 8044, 2295, 2577, 1480, 5743, 3304, 5499,
        330, 4303, 6863, 3822, 4600, 4751, 5628, 3822, 2918, 6675, 2400, 6663, 1403, 6849, 6029, 3145,
        6110, 3210, 747, 3229, 3056, 2918, 7733, 330, 4055, 7322, 5628, 2987, 3056, 1905, 2903, 669,
        5325, 2845, 4099, 5225, 6283, 4099, 5000, 642, 4055, 5345, 8034, 2918, 1041, 5769, 7051, 1538,
        2918, 3366, 608, 4303, 3921, 0, 2918, 1905, 218, 6687, 5963, 859, 3083, 2987, 896, 5056,
        1905, 2918, 4415, 7966, 7646, 2883, 5628, 7017, 8029, 6528, 4474, 6322, 5562, 6669, 4610, 7006
    };

    public static Player whoWon(Player playerOne, Player playerTwo) {

        playerOneHand = convertHand(playerOne.getHand());
        playerTwoHand = convertHand(playerTwo.getHand());

        if(!hasAlreadyLoaded) {
            try {
                File lookUpFile = new File("src/LookUpTables.txt");
                Scanner input = new Scanner(lookUpFile);
                boolean isFlushes = true;
                boolean isUnique = false;
                boolean isHashValues = false;

                while (input.hasNextLine()) {
                    String temp = input.next();

                    if (isFlushes) {
                        if (temp.contains(","))
                            flushes.add(Short.parseShort(temp.substring(0, temp.length() - 1)));
                        else {
                            flushes.add(Short.parseShort(temp));
                            isFlushes = false;
                            isUnique = true;
                        }
                    } else if (isUnique) {
                        if (temp.contains(","))
                            unique5.add(Short.parseShort(temp.substring(0, temp.length() - 1)));
                        else {
                            unique5.add(Short.parseShort(temp));
                            isUnique = false;
                            isHashValues = true;
                        }
                    } else if (isHashValues) {
                        if (temp.contains(","))
                            hash_values.add(Short.parseShort(temp.substring(0, temp.length() - 1)));
                        else
                            hash_values.add(Short.parseShort(temp));
                    }
                }
                input.close();
            } catch (FileNotFoundException e) {
                System.out.println("Could not find LookUpTables.txt");
            }
            hasAlreadyLoaded = true;
        }

        if(eval_5cards(playerOneHand) < eval_5cards(playerTwoHand))
            return playerOne;

        return playerTwo;
    }

    private static short eval_5cards(int[] hand)
    {
        // For look up tables
        int q = (hand[0] | hand[1] | hand[2] | hand[3] | hand[4]) >> 16;

        // This checks for any kind of Flushes
        if ((hand[0] & hand[1] & hand[2] & hand[3] & hand[4] & 0xf000) != 0)
            return flushes.get(q);

        // This checks for Straights and High Card hands
        if ( unique5.get(q) != 0)
            return unique5.get(q);

        // This performs a perfect-hash lookup for remaining possible hands
        long q1 = (hand[0] & 0xff) * (hand[1] & 0xff) * (hand[2] & 0xff) * (hand[3] & 0xff) * (hand[4] & 0xff);
        return hash_values.get((int)find_fast(q1));
    }

    // Hashing to find in hash tables
    private static long find_fast(long u)
    {
        long a, b, r;
        long maxUInt = 4294967295L;

        u += 0xe91aaa35;
        u = maxUInt % u;
        u ^= u >> 16;
        u = maxUInt  % u;
        u += u << 8;
        u = maxUInt  % u;
        u ^= u >> 4;
        u = maxUInt  % u;
        b  = (u >> 8) & 0x1ff;
        b = maxUInt % b;
        a  = (u + (u << 2)) >> 19;
        a = maxUInt % a;
        r  = a ^ hash_adjust[(int)b];
        r = maxUInt % r;
        return r;
    }

    /*

    Convert hand into single integers with the following bit pattern

            +--------+--------+--------+--------+
                AKQJT 98765432
            |xxxbbbbb|bbbbbbbb|cdhsrrrr|xxpppppp|
            +--------+--------+--------+--------+

            p = prime number of rank (deuce=2,trey=3,four=5,...,ace=41)
            r = rank of card (deuce=0,trey=1,four=2,five=3,...,ace=12)
            cdhs = suit of card (bit turned on based on suit of card)
                Diamond     Spades      Hearts      Clubs
                0100        0001        0010        1000
            b = bit turned on depending on rank of card
            x = padded 0's
     */

    private static String convertP(int value)
    {
        String output = Integer.toBinaryString(value);

        for(int i = output.length(); i < 6; i++) // pad zeros
            output = "0" + output;

        return output;
    }
    private static String convertR(int value)
    {
        String output = Integer.toBinaryString(value);

        for(int i = output.length(); i < 4; i++) // pad zeros
            output = "0" + output;

        return output;
    }

    private static int[] convertHand(Card[] hand)
    {
        String[] builder = new String[hand.length];

        for(int i = 0; i < hand.length; i++)
        {
            builder[i] = "";

            // prime value
            if(hand[i].getValue() == 1) // an Ace
                builder[i] = convertP(primes[primes.length-1]) + builder[i];
            else
                builder[i] = convertP(primes[hand[i].getValue()-2])  + builder[i];

            // after prime xx padded 0's
            builder[i] = "00" + builder[i];

            // rank values
            if(hand[i].getValue() == 1) // an Ace
                builder[i] = convertR(12) + builder[i];
            else
                builder[i] = convertR(hand[i].getValue()-2) + builder[i];

            // cdhs card 4 bit suit value
            if(hand[i].getSuit() == Suits.club)
            {
                builder[i] = "1000" + builder[i];
            }
            else if(hand[i].getSuit() == Suits.diamond)
            {
                builder[i] = "0100" + builder[i];
            }
            else if(hand[i].getSuit() == Suits.spade)
            {
                builder[i] = "0001" + builder[i];
            }
            else
            {
                builder[i] = "0010" + builder[i];
            }

            // b = rank of card
            if(hand[i].getValue() == 1) // an Ace
                for(int j = 2; j < 15; j++)
                {
                    if(j == 14)
                    {
                        builder[i] = "1" + builder[i];
                    }
                    else
                        builder[i] = "0" + builder[i];
                }
            else
                for(int j = 2; j < 15; j++)
                {
                    if(j == hand[i].getValue())
                    {
                        builder[i] = "1" + builder[i];
                    }
                    else
                        builder[i] = "0" + builder[i];

                }


            //front xxx padded 0's
            builder[i] = "000" + builder[i];
        }

        // convert the string into an int
        int[] converted = new int[hand.length];
        for(int index = 0; index < hand.length; index++) {
            for (int i = 0; i < builder[index].length(); i++) {
                String bit = Character.toString(builder[index].charAt(i));
                int parse = Integer.parseInt(bit);
                int mul = (int)Math.pow(2, (31 - i)); // shifts the bit to the proper place in the int

                converted[index] += parse * mul; // add the bit in the proper place to the int in the array
            }
        }
        return converted;
    }
}

// Suits class to allow for a static call of the characters to assure they are all the same ASCII value
class Suits
{
    public static final char diamond = '♢';
    public static final char club = '♣';
    public static final char spade = '♠';
    public static final char heart = '♡';
}