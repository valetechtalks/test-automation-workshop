<?php

namespace App\Http\Controllers;

use App\Models\Attendee;

class RefreshController extends Controller
{
    const URL = 'https://api.meetup.com/valetechtalks/events/268854460/rsvps?&sign=true&photo-host=public&fields=answers';

    public function index() {
        $attendances = json_decode(file_get_contents(self::URL));

        foreach($attendances as $attendance) {
            $member = $attendance->member;
            if(Attendee::memberId($member->id)->count() == 0) {
                Attendee::create([
                    'name' => $member->name,
                    'vendor_member_id' => $member->id
                ]);
            }
        }
    }
}
