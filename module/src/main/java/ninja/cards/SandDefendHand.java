package ninja.cards;

import ninja.actions.NinjutsuAction;
import static ninja.Ninja.getResourcePath;import ninja.Ninja;import ninja.enums.CardColorEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import ninja.powers.SandWall;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;import static ninja.Ninja.getResourcePath;import ninja.Ninja;

public class SandDefendHand extends CustomCard {
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("SandDefendHand");
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final int COST = 1;
    private static final int BLOCK_AMT = 8;
    private static final int UPGRADE_PLUS_BLOCK = 3;
    public static final String ID = "SandDefendHand";
    public static final String IMG_PATH = "img/cards_Ninja/SandDefendHand.png";
    public static final int NINJUTSU = 1;

    public SandDefendHand() {
        super(ID, NAME,Ninja.getResourcePath( IMG_PATH), COST, DESCRIPTION, CardType.SKILL, CardColorEnum.SILVER, CardRarity.COMMON, CardTarget.SELF);
        this.baseBlock = BLOCK_AMT;
        this.baseMagicNumber = 6;
        this.magicNumber = this.baseMagicNumber;
        this.tags.add(CardTags.HAND);
        this.tags.add(CardTags.NINJUTSU);
    };

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new GainBlockAction(p, p, this.block));
        this.addToBot(new NinjutsuAction(p,new ApplyPowerAction(p, p, new SandWall(p, this.magicNumber), this.magicNumber),NINJUTSU,"SandDefendHand"));
    }

    public void upgrade() {
        if(!this.upgraded){
            this.upgradeName();
            this.upgradeBlock(UPGRADE_PLUS_BLOCK);
            this.upgradeMagicNumber(3);
        }
    }

    public void applyPowers() {
        super.applyPowers();

        this.rawDescription = cardStrings.DESCRIPTION;
        this.rawDescription = this.rawDescription + cardStrings.EXTENDED_DESCRIPTION[0] + this.magicNumber;
        if (this.magicNumber == 1) {
            this.rawDescription = this.rawDescription + cardStrings.EXTENDED_DESCRIPTION[1];
        } else {
            this.rawDescription = this.rawDescription + cardStrings.EXTENDED_DESCRIPTION[2];
        }

        this.initializeDescription();
    }

    public AbstractCard makeCopy() {
        return new SandDefendHand();
    }
}

