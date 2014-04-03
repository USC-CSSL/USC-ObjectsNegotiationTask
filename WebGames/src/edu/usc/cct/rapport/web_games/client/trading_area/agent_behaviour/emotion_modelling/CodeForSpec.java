/*
package edu.usc.cct.rapport.web_games.client.trading_area.agent_behaviour.emotion_modelling;

public class CodeForSpec {

    /// <summary>
    /// Appraisal function used to update the value of emotion felt based on the behavior of the human
    /// </summary>
    /// <param name="round">The action taken by the human</param>
    protected virtual void Appraise(int[] round)
    {
        if (utilityType == UtilityType.NotFeelEmotions)
            return;
        if (ExpDevMode == ExpectationDeviationMode.AlwaysAnger)
        {
            emot = -0.6;
            return;
        }
        else if (ExpDevMode == ExpectationDeviationMode.AlwaysSmile)
        {
            emot = 0.6;
            return;
        }

        int[] humanAlloc = new int[] { round[0], round[1], round[2], round[3] };
        int[] agentAlloc = new int[] { round[4], round[5], round[6], round[7] };
        double myU = CalculateUtility(agentAlloc);
        double hU = CalculateUtility(humanAlloc) * pr_competitive + CalculateUtility(humanAlloc, GetAntiSymmetricVector(myPayoffVector)) * (1 - pr_competitive);

        // appraisal

        double total_worth = 0;
        for (int i = 0; i < 4; i++)
            total_worth += myPayoffVector[i] * GameForm.GData.ItemNumbers[i];

        int currentRound = historyOfUtilities.Count + 1;

        double total_recip_by_me = 0;
        for (int i = 3; i < historyOfUtilities.Count; i++)
            if (i % 2 == 1)
                total_recip_by_me += (double)historyOfUtilities[i] - (double)historyOfUtilities[i-1];

        double what_the_selfish_would_give = b;
        double what_the_equal_splitter_would_give = pr_competitive * total_worth / 2 + (1 - pr_competitive) * total_worth * 2 / 3;
        double what_the_slow_conceder_would_give = b + (currentRound / 2 - 1) * 10;
        double what_the_tit_for_tat_would_give = b + total_recip_by_me;

        double what_I_would_have_given = 0;
        if (this.GetType() == typeof(Agents.FixedAgent0))
            what_I_would_have_given = what_the_equal_splitter_would_give;
        else if (this.GetType() == typeof(Agents.FixedAgent1))
            what_I_would_have_given = what_the_selfish_would_give;
        else if (this.GetType() == typeof(Agents.SlowConceder))
            what_I_would_have_given = what_the_slow_conceder_would_give;
        else if (this.GetType() == typeof(Agents.ReciprocalBeta))
            what_I_would_have_given = what_the_tit_for_tat_would_give;

        double goal_related = 0;
        if (this.GetType() == typeof(Agents.FixedAgent0))
            goal_related = what_the_equal_splitter_would_give;
        else if (this.GetType() == typeof(Agents.FixedAgent1))
            goal_related = total_worth - other_b;
        else if (this.GetType() == typeof(Agents.SlowConceder))
            goal_related = what_the_slow_conceder_would_give;
        else if (this.GetType() == typeof(Agents.ReciprocalBeta))
            goal_related = what_the_tit_for_tat_would_give;

        
        double expected_human_given_util = 
            (ExpDevMode == ExpectationDeviationMode.Representative ?
            0.25 * (what_the_selfish_would_give + what_the_equal_splitter_would_give + what_the_slow_conceder_would_give + what_the_tit_for_tat_would_give) :
            (ExpDevMode == ExpectationDeviationMode.Self ? what_I_would_have_given : goal_related));
        double D = myU - expected_human_given_util;

        emot *= 0.9;

        if (PowerDifferential == PowerSetting.High)
        {
            if (D >= 0)
                emot += 0.15;
            else if (D >= -5)
                emot += -0.1;
            else if (D >= -15)
                emot += -0.3;
            else
                emot += -0.4;
        }
        else if (PowerDifferential == PowerSetting.Equal)
        {
            if (D >= 0)
                emot += 0.15;
            else if (D >= -15 && D < -5)
                emot += -0.2;
            else if (D < -15)
                emot += -0.3;
        }
        else
        {
            if (D >= 0)
                emot += 0.35;
            else if (D >= -5)
                emot += 0.1;
            else if (D >= -15)
                emot += -0.1;
            else
                emot += -0.2;
        }
    }

}


        /// <summary>
        /// Learning function; updated the probability that the human's payoff vector is symmetric or antisymmetric
        /// </summary>
        /// <param name="mine"></param>
        /// <param name="thine"></param>
        protected void UpdateProbabilityOfCompetitiveVector(int[] mine, int[] thine)
        {
            if (MainForm.WILL_DO_LEARNING)
            {
                double[] probabilityMeasures = new double[2];

                double countC = 0;
                for (int i = 0; i < 4; i++)
                {
                    if (mine[i] > 0 && myPayoffVector[i] == 5)
                        countC += mine[i];
                    else if (mine[i] > 0 && myPayoffVector[i] == 10)
                        countC += (double)mine[i] / 2;
                }
                countC++;

                double countO = 0;
                for (int i = 0; i < 4; i++)
                {
                    if (mine[i] > 0 && myPayoffVector[i] == 10)
                        countO += mine[i];
                    else if (mine[i] > 0 && myPayoffVector[i] == 5)
                        countO += (double)mine[i] / 2;
                }
                countO++;

                probabilityMeasures[0] = countC * pr_competitive; probabilityMeasures[1] = countO * (1 - pr_competitive);
                pr_competitive = probabilityMeasures[0] / (probabilityMeasures[0] + probabilityMeasures[1]);
            }
            else
                pr_competitive = 0;
        }

*/
