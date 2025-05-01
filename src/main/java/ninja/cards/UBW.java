package ninja.cards;

import ninja.actions.NinjutsuAction;
import ninja.actions.UBWAction;
import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import ninja.Ninja;

public class UBW extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("UBW");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final String IMG_PATH = "img/cards_Ninja/UBW.png";
    public static final String ID = "UBW";

    public UBW(){
        super (ID, NAME,Ninja.getResourcePath( IMG_PATH), 2, DESCRIPTION, CardType.ATTACK, CardColorEnum.SILVER, CardRarity.RARE, CardTarget.ALL_ENEMY);
        this.baseDamage = 8;
        this.tags.add(CardTags.NINJUTSU);
        this.tags.add(CardTags.BLADE);
        this.baseMagicNumber = 3;
        this.magicNumber = this.baseMagicNumber ;
    }

    public void use(AbstractPlayer p, AbstractMonster m ){

        this.addToBot(new NinjutsuAction(p,new UBWAction(this.damage),this.magicNumber,""));
    }

    public void applyPowers() {
        super.applyPowers();
        int count = 0;

        for(AbstractCard c : AbstractDungeon.actionManager.cardsPlayedThisCombat) {
            if (c.hasTag(CardTags.BLADE) || c.cardID=="YiCut" || c.cardID=="Shiv") {
                ++count;
            }
        }

        if(this.upgraded){
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
        }
        else {
            this.rawDescription = cardStrings.DESCRIPTION;
        }

        this.rawDescription = this.rawDescription + cardStrings.EXTENDED_DESCRIPTION[0] + count;
        if (count == 1) {
            this.rawDescription = this.rawDescription + cardStrings.EXTENDED_DESCRIPTION[1];
        } else {
            this.rawDescription = this.rawDescription + cardStrings.EXTENDED_DESCRIPTION[2];
        }

        this.initializeDescription();
    }

    public void upgrade(){
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBlock(1);
            this.upgradeMagicNumber(-2);
            this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    public AbstractCard makeCopy(){
        return new UBW();
    }
}
