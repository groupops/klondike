package com.epam.klondike;

import java.util.ArrayList;
import java.util.List;

public class Piles {

  private List<Pile> piles;
  private int NUMBER_OF_PILES = 7;

  public Piles() {
    piles = new ArrayList<>(NUMBER_OF_PILES);
    for (int i = 0; i < NUMBER_OF_PILES; i++){
      Pile pile = new Pile();
      piles.add(pile);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Piles piles1 = (Piles) o;

    return NUMBER_OF_PILES == piles1.NUMBER_OF_PILES &&
        !(piles != null ? !piles.equals(piles1.piles) : piles1.piles != null);

  }

  @Override
  public int hashCode() {
    int result = piles != null ? piles.hashCode() : 0;
    result = 31 * result + NUMBER_OF_PILES;
    return result;
  }

  @Override
  public String toString() {
    return "Piles{" +
        "piles=" + piles +
        ", NUMBER_OF_PILES=" + NUMBER_OF_PILES +
        '}';
  }

  public int getNumberOfPiles() {
    return NUMBER_OF_PILES;
  }

  public void setNumberOfPiles(int numberOfPiles){
    this.NUMBER_OF_PILES = numberOfPiles;
  }

  public Pile getPile(int number){
    return piles.get(number);
  }

}
